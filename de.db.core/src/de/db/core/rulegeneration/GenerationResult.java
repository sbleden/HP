package de.db.core.rulegeneration;

import de.db.core.dpll.ClauseSet;
import de.db.core.interfaces.IGenerationResult;

public class GenerationResult implements IGenerationResult {

	private ClauseSet clauseSet;

	public GenerationResult(ClauseSet clauseSet) {
		super();
		this.clauseSet = clauseSet;
	}

}
