package de.db.core.interfaces;

import java.util.Set;

public interface ICostDeterminer {

	public boolean isCostLiteral(String key);

	public long addCosts(Set<IOperand> allreadyAssigendOperands, long baseCosts, IOperand operandToAssign);
}
