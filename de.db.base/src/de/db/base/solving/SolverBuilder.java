package de.db.base.solving;

import de.db.base.solving.interfaces.ISolver;
import de.db.base.solving.provider.IPersonProvider;
import de.db.base.solving.provider.IPersonWeigthDeterminer;
import de.db.base.solving.provider.NoPersonProvider;
import de.db.base.solving.provider.NoWeightDeterminer;

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
		return new Solver(personProvider == null ? new NoPersonProvider() : personProvider,
				personWeigthDeterminer == null ? new NoWeightDeterminer() : personWeigthDeterminer);
	}

}
