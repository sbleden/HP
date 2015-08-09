package de.db.core.interfaces;

import java.util.Set;

public interface IFormula {

	public enum Operator {

		AND(-1), OR(-1), NOT(1), IMPLIES(2), EQUIVALENT(-1);

		/**
		 * -1 --> more than zero operands are allowed
		 */
		private int numberOfOperands;

		private Operator(int numberOfOperands) {
			this.numberOfOperands = numberOfOperands;
		}

		public int getNumberOfOperands() {
			return numberOfOperands;
		}

	}

	public Operator getOperator();

	public Set<IFormula> getOperands();

}
