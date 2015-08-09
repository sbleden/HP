package de.db.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.db.base.descriptor.MultipleSingleTableRoomDescriptor;
import de.db.base.descriptor.TableDescription;
import de.db.base.solving.interfaces.IRoomDescriptor;
import de.db.base.solving.interfaces.ITableDescription;

public class MultipleSingleTableRoomCreator {

	public IRoomDescriptor createMultipleSingleTableInCircle(int numberOfTables, int personsPerTable) {
		MultipleSingleTableRoomDescriptor roomDescriptor = new MultipleSingleTableRoomDescriptor(numberOfTables);

		List<ITableDescription> tableDescriptions = new ArrayList<>();
		for (int i = 0; i < numberOfTables; i++) {
			tableDescriptions.add(new TableDescription(i, personsPerTable));
		}

		for (int i = 0; i < numberOfTables; i++) {
			Set<ITableDescription> neighbours = new HashSet<>();
			if (i == 0) {
				neighbours.add(tableDescriptions.get(tableDescriptions.size() - 1));
			} else {
				neighbours.add(tableDescriptions.get(i - 1));
			}
			if (i == 5) {
				neighbours.add(tableDescriptions.get(0));
			} else {
				neighbours.add(tableDescriptions.get(i));
			}
			roomDescriptor.addTable(tableDescriptions.get(i), neighbours);
		}

		return roomDescriptor;
	}
}
