package de.db.base.solving.interfaces;

import java.util.Set;

import de.db.base.model.Table;

public interface IRoomDescriptor {

	public Set<Table> getTables();

	public boolean isNeighbourTable(Table table1, Table table2);

}
