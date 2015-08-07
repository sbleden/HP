package de.db.base.solving;

import de.db.base.solving.interfaces.IRoomDescriptor;
import de.db.base.solving.interfaces.ISolver;
import de.db.base.solving.interfaces.ITableDescription;
import de.db.base.solving.provider.IPersonProvider;
import de.db.base.solving.provider.IPersonWeigthDeterminer;

public class SolverBuilder {

	public ISolver create(IPersonProvider personProvider, IPersonWeigthDeterminer personWeigthDeterminer,
			IRoomDescriptor roomDescriptor, ITableDescription tableDescription) {
		return new ShuffleSolver(personProvider, personWeigthDeterminer, roomDescriptor, tableDescription, 1000);
	}

}
