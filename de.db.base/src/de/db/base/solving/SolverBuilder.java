package de.db.base.solving;

import de.db.base.solving.interfaces.ISolver;
import de.db.base.solving.provider.IPersonProvider;
import de.db.base.solving.provider.IPersonWeigthDeterminer;

public class SolverBuilder {

	protected IPersonProvider personProvider;
	protected IPersonWeigthDeterminer personWeigthDeterminer;

	public SolverBuilder withPersons(IPersonProvider personProvider) {
		this.personProvider = personProvider;
		return this;
	}

	public SolverBuilder withWeigthDeterminer(IPersonWeigthDeterminer determiner) {
		this.personWeigthDeterminer = determiner;
		return this;
	}

	public ISolver create() {
		performPreChecks();
		return new Solver(personProvider, personWeigthDeterminer);
	}

	private void performPreChecks() {
		if (personProvider == null || personWeigthDeterminer == null) {
			throw new RuntimeException();
		}
	}

}
