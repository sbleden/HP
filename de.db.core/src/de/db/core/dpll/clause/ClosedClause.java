package de.db.core.dpll.clause;

import java.util.Set;

import com.google.common.collect.Sets;

import de.db.core.dpll.Literal;

public class ClosedClause implements IClause {

	private boolean isTrue;

	ClosedClause(boolean isTrue) {
		super();
		this.isTrue = isTrue;
	}

	@Override
	public Set<Literal> getLiterals() {
		return Sets.newHashSet();
	}

	@Override
	public IClause unitPropagation(Literal literal) {
		throw new UnsupportedOperationException("Unitpropagation on a closed Clause is not allowed");
	}

	@Override
	public State getState() {
		return isTrue ? State.TRUE : State.FALSE;
	}

}
