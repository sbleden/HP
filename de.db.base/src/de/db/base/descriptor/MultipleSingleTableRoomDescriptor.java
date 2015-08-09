package de.db.base.descriptor;

import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import de.db.base.solving.interfaces.IRoomDescriptor;
import de.db.base.solving.interfaces.ITableDescription;

public class MultipleSingleTableRoomDescriptor implements IRoomDescriptor {

	private SetMultimap<ITableDescription, ITableDescription> multimap = HashMultimap.create();
	private int numberOfTables;

	public MultipleSingleTableRoomDescriptor(int numberOfTables) {
		this.numberOfTables = numberOfTables;
	}

	public void addTable(ITableDescription table, Set<ITableDescription> neighbours) {
		if (multimap.keySet().size() > numberOfTables) {
			throw new IllegalStateException();
		}
		multimap.putAll(table, neighbours);
		neighbours.forEach(n -> multimap.put(n, table));
	}

	@Override
	public Set<ITableDescription> getTables() {
		return multimap.keySet();
	}

	@Override
	public boolean isNeighbourTable(ITableDescription table1, ITableDescription table2) {
		return multimap.get(table1).contains(table2);
	}

}
