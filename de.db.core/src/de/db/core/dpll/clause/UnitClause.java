package de.db.core.dpll.clause;

import java.util.Set;

import de.db.core.dpll.Literal;

public class UnitClause implements IClause {

	private Set<Literal> unitLiterals;

	protected UnitClause(Set<Literal> unitLiterals) {
		super();
		this.unitLiterals = unitLiterals;
	}

	@Override
	public Set<Literal> getLiterals() {
		return unitLiterals;
	}

	@Override
	public IClause unitPropagation(Literal literal) {
		throw new UnsupportedOperationException("Unitpropagation on a unitclause is not allowed");
	}

	@Override
	public State getState() {
		return State.UNIT;
	}

}
