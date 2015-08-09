package de.db.core.dpll.clause;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import de.db.core.dpll.Literal;

public class CardinalityClause implements IClause {

	private int minCardinality;
	private int maxCardinality;
	private Set<Literal> literals;
	private int fullfilled;

	public CardinalityClause(int minCardinality, int maxCardinality, Set<Literal> literals) {
		super();
		Preconditions.checkArgument(maxCardinality > minCardinality);
		this.minCardinality = minCardinality;
		this.maxCardinality = maxCardinality;
		this.literals = literals;
		this.fullfilled = 0;
	}

	private CardinalityClause(int minCardinality, int maxCardinality, Set<Literal> literals, int fullfilled) {
		this(minCardinality, maxCardinality, literals);
		this.fullfilled = fullfilled;
	}

	@Override
	public Set<Literal> getLiterals() {
		return literals;
	}

	@Override
	public IClause unitPropagation(Literal literal) {
		Set<Literal> newLiterals = new HashSet<>(literals);
		newLiterals.remove(literal.getNegatedPartner());
		newLiterals.remove(literal);
		return createClause(minCardinality, maxCardinality, newLiterals,
				fullfilled + (literals.contains(literal) ? 1 : 0));
	}

	private IClause createClause(int minCardinality, int maxCardinality, Set<Literal> literals, int fullfilled) {
		if (fullfilled >= minCardinality) {
			if (fullfilled > maxCardinality) {
				return new ClosedClause(false);
			}
			if (fullfilled + literals.size() <= maxCardinality) {
				return new ClosedClause(true);
			}
			if (fullfilled == maxCardinality) {
				return new UnitClause(literals.stream().map(l -> l.getNegatedPartner()).collect(Collectors.toSet()));
			}
		} else {
			if (fullfilled + literals.size() < minCardinality) {
				return new ClosedClause(false);
			}
			if (fullfilled + literals.size() == minCardinality) {
				return new UnitClause(literals);
			}
		}
		return new CardinalityClause(minCardinality, maxCardinality, literals, fullfilled);
	}

	@Override
	public State getState() {
		return State.OPEN;
	}

}
