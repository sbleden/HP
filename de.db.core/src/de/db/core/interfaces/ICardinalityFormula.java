package de.db.core.interfaces;

import java.util.Set;

public interface ICardinalityFormula {

	public int getMinCardinality();

	public int getMaxCardinality();

	public Set<IOperand> getOperands();

}
