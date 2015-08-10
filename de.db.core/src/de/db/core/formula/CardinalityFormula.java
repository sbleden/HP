package de.db.core.formula;

import java.util.Set;
import java.util.TreeSet;

import de.db.core.interfaces.ICardinalityFormula;
import de.db.core.interfaces.IOperand;

public class CardinalityFormula implements ICardinalityFormula {

	private int minCardinality;
	private int maxCardinality;
	private Set<IOperand> operands;

	public CardinalityFormula(int minCardinality, int maxCardinality) {
		operands = new TreeSet<>();
		this.minCardinality = minCardinality;
		this.maxCardinality = maxCardinality;
	}

	public CardinalityFormula or(ICardinalityFormula formula) {
		CardinalityFormula newFormula = new CardinalityFormula(getMinCardinality(), getMaxCardinality());
		newFormula.operands.addAll(this.getOperands());
		newFormula.operands.addAll(formula.getOperands());
		return newFormula;
	}

	public void add(IOperand operand) {
		this.operands.add(operand);
	}

	public void addAll(Set<IOperand> operands) {
		this.operands.addAll(operands);
	}

	@Override
	public int getMinCardinality() {
		return this.minCardinality;
	}

	@Override
	public int getMaxCardinality() {
		return this.maxCardinality;
	}

	@Override
	public Set<IOperand> getOperands() {
		return this.operands;
	}
}
