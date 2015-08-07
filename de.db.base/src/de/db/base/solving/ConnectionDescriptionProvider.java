package de.db.base.solving;

import com.google.common.collect.HashBasedTable;

import de.db.base.model.Person;
import de.db.base.solving.interfaces.IConnectionDescription;
import de.db.base.solving.interfaces.IConnectionDescriptionProvider;

public class ConnectionDescriptionProvider implements IConnectionDescriptionProvider {

	private HashBasedTable<Integer, Integer, IConnectionDescription> connectionDescriptionTable = HashBasedTable
			.create();

	public void addConnectionDescription(Person person1, Person person2, IConnectionDescription connectionDescription) {
		this.connectionDescriptionTable.put(person1.getId(), person2.getId(), connectionDescription);
	}

	@Override
	public IConnectionDescription getConnectionDescription(Person person1, Person person2) {
		return connectionDescriptionTable.get(person1.getId(), person2.getId());
	}

}
