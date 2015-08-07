package de.db.base.solving.interfaces;

import de.db.base.solving.InvalidInputException;

public interface ISolver {

	public ISolvingResult calculate() throws InvalidInputException;

}
