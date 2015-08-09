package de.db.core.dpll.clause;

import java.util.Set;

import de.db.core.dpll.Literal;

public interface IClause {

	public enum State {
		UNIT, FALSE, TRUE, OPEN;
	}

	public Set<Literal> getLiterals();

	public IClause unitPropagation(Literal literal);

	public State getState();

}