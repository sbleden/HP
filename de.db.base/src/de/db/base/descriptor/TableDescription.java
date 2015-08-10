package de.db.base.descriptor;

import de.db.base.model.interfaces.ITableDescription;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tableNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableDescription other = (TableDescription) obj;
		if (tableNumber != other.tableNumber)
			return false;
		return true;
	}

}
