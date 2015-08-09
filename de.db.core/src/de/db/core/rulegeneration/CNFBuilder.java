package de.db.core.rulegeneration;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import de.db.core.dpll.clause.IClause;
import de.db.core.interfaces.IFormula;

public class CNFBuilder {

	public Set<IClause> createClauses(IFormula formula) {
		return new HashSet<>();
	}

	public Set<IClause> createClauses(Set<IFormula> formulas) {
		return formulas.stream().map(this::createClauses).flatMap(l -> l.stream()).collect(Collectors.toSet());
	}

}
