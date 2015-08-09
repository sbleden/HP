package de.db.core.dpll;

import de.db.util.collections.MultiKeyHashMap;

public class LiteralFactory {

	private static LiteralFactory instance;

	private MultiKeyHashMap<String, Boolean, Literal> literalMap;
	private long counter = 0;

	private LiteralFactory() {
		literalMap = new MultiKeyHashMap<>();
	}

	public synchronized Literal create(String code, boolean negated) {
		Literal literal = literalMap.get(code, negated);
		if (literal == null) {
			literal = new Literal(code, negated, counter++);
			Literal negation = new Literal(code, !negated, counter++);
			literal.setNegatedPartner(negation);
			negation.setNegatedPartner(literal);
			literalMap.put(code, negated, literal);
			literalMap.put(code, !negated, negation);
		}
		return literal;
	}

	public synchronized static LiteralFactory getInstance() {
		if (instance == null) {
			instance = new LiteralFactory();
		}
		return instance;
	}
}
