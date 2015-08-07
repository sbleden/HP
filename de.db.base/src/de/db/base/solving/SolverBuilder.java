package de.db.base.solving;

import de.db.base.solving.interfaces.IRoomDescriptor;
import de.db.base.solving.interfaces.ISolver;
import de.db.base.solving.provider.IPersonProvider;
import de.db.base.solving.provider.IPersonWeigthDeterminer;

public class SolverBuilder {

	public ISolver create(IPersonProvider personProvider, IPersonWeigthDeterminer personWeigthDeterminer,
			IRoomDescriptor roomDescriptor) {
		performPreChecks(personProvider, personWeigthDeterminer, roomDescriptor);
		return new ShuffleSolver(personProvider, personWeigthDeterminer, roomDescriptor, 1000);
	}

	private void performPreChecks(IPersonProvider personProvider, IPersonWeigthDeterminer personWeigthDeterminer,
			IRoomDescriptor roomDescriptor) {
		if (personProvider == null || personWeigthDeterminer == null || roomDescriptor == null) {
			throw new RuntimeException();
		}
	}

}
