package de.db.base.solving;

import com.google.common.base.Preconditions;

import de.db.base.solving.interfaces.IRoomDescriptor;
import de.db.base.solving.interfaces.ISolver;
import de.db.base.solving.provider.IPersonProvider;
import de.db.base.solving.provider.IPersonWeigthDeterminer;

public class SolverBuilder {

	public ISolver create(IPersonProvider personProvider, IPersonWeigthDeterminer personWeigthDeterminer,
			IRoomDescriptor roomDescriptor) {
		performPreChecks(personProvider, personWeigthDeterminer, roomDescriptor);
		return new ShuffleSolver(personProvider, personWeigthDeterminer, roomDescriptor, 10000);
	}

	private void performPreChecks(IPersonProvider personProvider, IPersonWeigthDeterminer personWeigthDeterminer,
			IRoomDescriptor roomDescriptor) {
		Preconditions.checkNotNull(personProvider);
		Preconditions.checkNotNull(roomDescriptor);
		Preconditions.checkNotNull(personWeigthDeterminer);
	}

}
