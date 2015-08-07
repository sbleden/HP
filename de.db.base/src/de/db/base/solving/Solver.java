package de.db.base.solving;

import de.db.base.solving.interfaces.ISolver;
import de.db.base.solving.interfaces.ISolvingResult;
import de.db.base.solving.provider.IPersonProvider;
import de.db.base.solving.provider.IPersonWeigthDeterminer;

public class Solver implements ISolver {

	protected IPersonProvider personProvider;
	protected IPersonWeigthDeterminer personWeigthDeterminer;

	public Solver(IPersonProvider personProvider, IPersonWeigthDeterminer personWeigthDeterminer) {
		super();
		this.personProvider = personProvider;
		this.personWeigthDeterminer = personWeigthDeterminer;
	}

	@Override
	public ISolvingResult calculate() {
		// TODO Auto-generated method stub
		return null;
	}

}
