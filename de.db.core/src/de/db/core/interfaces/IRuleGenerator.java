package de.db.core.interfaces;

import java.util.Set;

public interface IRuleGenerator {

	public IGenerationResult generate(String key, Set<IFormula> formulas);

	public ICalculationResult calculate(String key, ICostDeterminer costDeterminer);

}
