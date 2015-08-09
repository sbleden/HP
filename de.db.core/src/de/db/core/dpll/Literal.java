package de.db.core.dpll;

public class Literal {

	private final String code;
	private final boolean negated;
	private final int hash;
	private Literal negatedPartner;

	protected Literal(String code, boolean negated, long id) {
		super();
		this.code = code;
		this.negated = negated;
		this.hash = (int) id;
	}

	protected void setNegatedPartner(Literal negatedPartner) {
		this.negatedPartner = negatedPartner;
	}

	@Override
	public int hashCode() {
		return hash;
	}

	public String getCode() {
		return code;
	}

	public Literal getNegatedPartner() {
		return negatedPartner;
	}

	public boolean isNegated() {
		return negated;
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj;
	}

}
