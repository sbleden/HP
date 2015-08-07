package de.db.base.solving.provider;

import de.db.base.model.CorrelationProvider;
import de.db.base.model.Person;
import de.db.base.model.interfaces.ICorrelationProvider;
import de.db.base.solving.interfaces.IConnectionDescription;
import de.db.base.solving.interfaces.IConnectionDescriptionProvider;

public class SimpleWeightDeterminer implements IPersonWeigthDeterminer {

	private IConnectionDescriptionProvider connectionDescriptionProvider;
	private ICorrelationProvider correlationProvider;

	public SimpleWeightDeterminer(ICorrelationProvider correlationProvider,
			IConnectionDescriptionProvider connectionDescriptionProvider) {
		this.correlationProvider = correlationProvider;
		this.connectionDescriptionProvider = connectionDescriptionProvider;
	}

	public int weigth(Person person1, Person person2) {
		Integer correlation = this.correlationProvider.getCorrelation(person1, person2);
		IConnectionDescription connectionDescription = this.connectionDescriptionProvider
				.getConnectionDescription(person1, person2);
		if (connectionDescription.equalTables()) {
			return CorrelationProvider.MAX_CORRELATION - correlation;
		} else if (connectionDescription.isNeighbourTable()) {
			return (CorrelationProvider.MAX_CORRELATION - correlation) / 2;
		}
		return correlation;
	}
}
