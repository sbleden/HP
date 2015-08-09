package de.db.base.solving.provider;

import com.google.common.collect.Sets;

import de.db.base.model.CorrelationProvider;
import de.db.base.model.Person;
import de.db.base.model.interfaces.ICorrelationProvider;
import de.db.base.solving.interfaces.IConnectionDescription;

public class SimpleWeightDeterminer implements IPersonWeigthDeterminer {

	private ICorrelationProvider correlationProvider;

	public SimpleWeightDeterminer(ICorrelationProvider correlationProvider) {
		this.correlationProvider = correlationProvider;
	}

	public int weigth(IConnectionDescription description, Person person1, Person person2) {
		Integer correlation = this.correlationProvider.getCorrelation(person1, person2);
		if (description.equalTables()) {
			return CorrelationProvider.MAX_CORRELATION - correlation;
		} else if (description.isNeighbourTable()) {
			return (CorrelationProvider.MAX_CORRELATION - correlation) / 2;
		}
		return correlation;
	}
}
