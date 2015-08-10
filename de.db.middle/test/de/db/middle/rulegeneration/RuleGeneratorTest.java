package de.db.middle.rulegeneration;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Sets;

import de.db.base.descriptor.MultipleSingleTableRoomDescriptor;
import de.db.base.descriptor.TableDescription;
import de.db.base.model.PersonProvider;
import de.db.core.interfaces.ICardinalityFormula;
import de.db.core.interfaces.IOperand;
import de.db.middle.AbstractMiddleTest;

public class RuleGeneratorTest extends AbstractMiddleTest {

	private RuleGenerator ruleGenerator;
	private PersonProvider personProvider;
	private MultipleSingleTableRoomDescriptor roomDescriptor;

	private int tableNumber1 = 0;
	private int tableNumber2 = 1;

	@Override
	protected void setUp() throws Exception {

		personProvider = new PersonProvider();
		personProvider.addPerson(lisa);
		personProvider.addPerson(peter);
		personProvider.addPerson(hans);

		roomDescriptor = new MultipleSingleTableRoomDescriptor(2);
		TableDescription tableDesc1 = new TableDescription(tableNumber1, 2);
		TableDescription tableDesc2 = new TableDescription(tableNumber2, 1);
		roomDescriptor.addTable(tableDesc1, Sets.newHashSet(tableDesc2));
		roomDescriptor.addTable(tableDesc2, Sets.newHashSet(tableDesc1));

		ruleGenerator = new RuleGenerator(roomDescriptor, personProvider);
	}

	public void testBasicRuleGeneration() {
		List<ICardinalityFormula> formulas = ruleGenerator.generate();
		assertEquals(2, formulas.size());
		ICardinalityFormula formula = formulas.get(0);
		assertEquals(0, formula.getMinCardinality());
		assertEquals(1, formula.getMaxCardinality());
		assertEquals("1-Hans, 1-Lisa, 1-Peter", formula.toString());

		formula = formulas.get(1);
		assertEquals(1, formula.getMinCardinality());
		assertEquals(2, formula.getMaxCardinality());
		assertEquals("0-Hans, 0-Lisa, 0-Peter", formula.toString());
	}

	public void testOperandTable() {
		ruleGenerator.generate();
		assertTrue(ruleGenerator.getOperandTable().rowKeySet().contains(tableNumber1));
		assertTrue(ruleGenerator.getOperandTable().rowKeySet().contains(tableNumber2));
		assertTrue(ruleGenerator.getOperandTable().columnKeySet().contains(lisa.getId()));
		assertTrue(ruleGenerator.getOperandTable().columnKeySet().contains(peter.getId()));
		assertTrue(ruleGenerator.getOperandTable().columnKeySet().contains(hans.getId()));
		assertEquals(6, ruleGenerator.getOperandTable().values().size());

		assertTrue(containsOperandKey("0-Lisa", ruleGenerator.getOperandTable().values()));
		assertTrue(containsOperandKey("1-Lisa", ruleGenerator.getOperandTable().values()));
		assertTrue(containsOperandKey("0-Peter", ruleGenerator.getOperandTable().values()));
		assertTrue(containsOperandKey("1-Peter", ruleGenerator.getOperandTable().values()));
		assertTrue(containsOperandKey("0-Hans", ruleGenerator.getOperandTable().values()));
		assertTrue(containsOperandKey("1-Hans", ruleGenerator.getOperandTable().values()));
	}

	private boolean containsOperandKey(String key, Collection<IOperand> operands) {
		for (IOperand operand : operands) {
			if (key.equals(operand.getKey())) {
				return true;
			}
		}
		return false;
	}
}
