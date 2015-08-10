package de.db.core.dpll.clause;

import java.util.Set;

import de.db.core.dpll.Literal;

public class ORClause extends CardinalityClause {

	public ORClause(Set<Literal> literals) {
		super(1, Integer.MAX_VALUE, literals);
	}

}
