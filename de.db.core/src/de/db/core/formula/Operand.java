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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isNegated ? 1231 : 1237);
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operand other = (Operand) obj;
		if (isNegated != other.isNegated)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (isNegated()) {
			sb.append("!");
		}
		sb.append(getKey());
		return sb.toString();
	}

	@Override
	public int compareTo(IOperand o) {
		return getKey().compareTo(o.getKey());
	}

}
