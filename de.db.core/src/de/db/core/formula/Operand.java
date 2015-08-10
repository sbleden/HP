package de.db.core.formula;

import de.db.core.interfaces.IOperand;

public class Operand implements IOperand {

	private String key;
	private boolean isNegated = false;

	public Operand(String key) {
		this.key = key;
	}

	public Operand(String key, boolean isNegated) {
		this(key);
		this.isNegated = isNegated;
	}

	public Operand not() {
		return new Operand(getKey(), !isNegated());
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public boolean isNegated() {
		return isNegated;
	}

}
