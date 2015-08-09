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
			literalMap.put(code, negated, literal);
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
