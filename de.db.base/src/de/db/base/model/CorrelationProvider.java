package de.db.base.model;

import com.google.common.collect.HashBasedTable;

import de.db.base.model.interfaces.ICorrelationProvider;

public class CorrelationProvider implements ICorrelationProvider {

	public static int MIN_CORRELATION = 0;
	public static int MAX_CORRELATION = 10;

	private HashBasedTable<Integer, Integer, Integer> correlationTable = HashBasedTable.create();

	/**
	 * The correlation value has to be between MIN_CORRELATION and
	 * MAX_CORRELATION
	 */
	public void addCorrelation(Person person1, Person person2, int correlation) {
		this.correlationTable.put(person1.getId(), person2.getId(), correlation);
	}

	@Override
	public Integer getCorrelation(Person person1, Person person2) {
		return correlationTable.get(person1.getId(), person2.getId());
	}

}
