package de.db.base.model.interfaces;

import java.util.Set;

public interface IRoomDescriptor {

	public Set<ITableDescription> getTables();

	public boolean isNeighbourTable(ITableDescription table1, ITableDescription table2);

}
