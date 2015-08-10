package de.db.core.formula;

import java.util.Set;
import java.util.TreeSet;

import de.db.core.interfaces.IFormula;

public class Formula implements IFormula {

	private Operator operator;
	private Set<IFormula> operands;

	public Formula() {
		operands = new TreeSet<>();
	}

	public Formula(Operator operator) {
		this();
		this.operator = operator;
	}

	public Formula and(IFormula formula) {
		Formula newFormula = new Formula(Operator.AND);
		addOperands(formula, newFormula);
		return newFormula;
	}

	public Formula or(IFormula formula) {
		Formula newFormula = new Formula(Operator.OR);
		addOperands(formula, newFormula);
		return newFormula;
	}

	public Formula implies(IFormula formula) {
		Formula newFormula = new Formula(Operator.IMPLIES);
		addOperands(formula, newFormula);
		return newFormula;
	}

	public Formula equivalent(IFormula formula) {
		Formula newFormula = new Formula(Operator.EQUIVALENT);
		addOperands(formula, newFormula);
		return newFormula;
	}

	public Formula not() {
		Formula newFormula = new Formula(Operator.NOT);
		newFormula.operands.add(this);
		return newFormula;
	}

	private void addOperands(IFormula formula, Formula newFormula) {
		newFormula.operands.add(this);
		newFormula.operands.add(formula);
	}

	@Override
	public Operator getOperator() {
		return this.operator;
	}

	@Override
	public Set<IFormula> getOperands() {
		return this.operands;
	}

}
