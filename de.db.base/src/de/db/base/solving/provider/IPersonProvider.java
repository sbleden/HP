package de.db.base.solving.provider;

import java.util.HashSet;
import java.util.Set;

import de.db.base.model.Person;

public interface IPersonProvider {

	public default Set<Person> getPersons() {
		return new HashSet<>();
	}

}
