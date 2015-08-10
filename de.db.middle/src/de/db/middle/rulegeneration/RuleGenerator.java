package de.db.middle.rulegeneration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.HashBasedTable;

import de.db.base.model.Person;
import de.db.base.model.interfaces.IPersonProvider;
import de.db.base.model.interfaces.IRoomDescriptor;
import de.db.base.model.interfaces.ITableDescription;
import de.db.core.formula.CardinalityFormula;
import de.db.core.formula.Operand;
import de.db.core.interfaces.ICardinalityFormula;
import de.db.core.interfaces.IOperand;

public class RuleGenerator {

	// Table Number, Person Id, Operand
	private HashBasedTable<Integer, String, IOperand> operandTable = HashBasedTable.create();

	private IRoomDescriptor roomDescriptor;
	private IPersonProvider personProvider;

	public RuleGenerator(IRoomDescriptor roomDescriptor, IPersonProvider personProvider) {
		this.roomDescriptor = roomDescriptor;
		this.personProvider = personProvider;
	}

	public List<ICardinalityFormula> generate() {
		List<ICardinalityFormula> formulas = new ArrayList<>();
		for (ITableDescription tableDesc : roomDescriptor.getTables()) {
			Set<IOperand> operands = new HashSet<>();
			for (Person person : personProvider.getPersons()) {
				Operand operand = new Operand(tableDesc.getTableNumber() + "-" + person.getId());
				operandTable.put(tableDesc.getTableNumber(), person.getId(), operand);
				operands.add(operand);
			}
			int numberOfPlaces = tableDesc.getNumberOfPlaces();
			CardinalityFormula formula = new CardinalityFormula(numberOfPlaces - 1, numberOfPlaces);
			formula.addAll(operands);
			formulas.add(formula);
		}
		return formulas;
	}

	public HashBasedTable<Integer, String, IOperand> getOperandTable() {
		return this.operandTable;
	}
}
