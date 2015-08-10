package de.db.base.descriptor;

import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import de.db.base.model.interfaces.IRoomDescriptor;
import de.db.base.model.interfaces.ITableDescription;

public class MultipleSingleTableRoomDescriptor implements IRoomDescriptor {

	private SetMultimap<ITableDescription, ITableDescription> neighboursMap = HashMultimap.create();
	private int numberOfTables;

	public MultipleSingleTableRoomDescriptor(int numberOfTables) {
		this.numberOfTables = numberOfTables;
	}

	public void addTable(ITableDescription table, Set<ITableDescription> neighbours) {
		if (neighboursMap.keySet().size() > numberOfTables || neighboursMap.containsKey(table)) {
			throw new IllegalStateException();
		}
		neighboursMap.putAll(table, neighbours);
	}

	@Override
	public Set<ITableDescription> getTables() {
		return neighboursMap.keySet();
	}

	@Override
	public boolean isNeighbourTable(ITableDescription table1, ITableDescription table2) {
		boolean isNeighbourTable = false;
		Set<ITableDescription> neighbours = neighboursMap.get(table1);
		if (neighbours != null && neighbours.contains(table2)) {
			isNeighbourTable = true;
		}

		if (!isNeighbourTable) {
			neighbours = neighboursMap.get(table2);
			if (neighbours != null && neighbours.contains(table1)) {
				isNeighbourTable = true;
			}
		}
		return isNeighbourTable;
	}

}
