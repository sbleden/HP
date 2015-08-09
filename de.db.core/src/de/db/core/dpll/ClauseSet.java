package de.db.core.dpll;

import java.util.HashMap;
import java.util.List;

import de.db.core.dpll.clause.ORClause;

public class ClauseSet {

	private List<ORClause> clauses;
	private HashMap<Literal, ORClause> literalClauseIndex;

	public ClauseSet(List<ORClause> clauses) {
		super();
		this.clauses = clauses;
		buildIndex();
	}

	private void buildIndex() {
		clauses.stream().forEach(c -> c.getLiterals().stream().forEach(l -> literalClauseIndex.put(l, c)));
	}
}
