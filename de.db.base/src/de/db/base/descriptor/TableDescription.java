package de.db.base.descriptor;

import de.db.base.solving.interfaces.ITableDescription;

public class TableDescription implements ITableDescription {

	private int tableNumber;
	private int numberOfPlaces;

	public TableDescription(int tableNumber, int numberOfPlaces) {
		this.tableNumber = tableNumber;
		this.numberOfPlaces = numberOfPlaces;
	}

	@Override
	public int getNumberOfPlaces() {
		return numberOfPlaces;
	}

	@Override
	public int getTableNumber() {
		return tableNumber;
	}

}
