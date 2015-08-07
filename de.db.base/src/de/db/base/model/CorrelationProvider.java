package de.db.base.model;

import com.google.common.collect.HashBasedTable;

public class CorrelationProvider {

	private HashBasedTable<Integer, Integer, Integer> correlationTable = HashBasedTable.create();

	public void addCorrelation(int idPerson1, int idPerson2, int correlation) {
		this.correlationTable.put(idPerson1, idPerson2, correlation);
	}
}
