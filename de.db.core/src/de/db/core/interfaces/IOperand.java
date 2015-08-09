package de.db.core.interfaces;

import java.util.HashSet;
import java.util.Set;

public interface IOperand extends IFormula {

	public String getKey();

	public boolean isNegated();

	@Override
	default Operator getOperator() {
		return null;
	}

	@Override
	default Set<IFormula> getOperands() {
		return new HashSet<>();
	}
}
