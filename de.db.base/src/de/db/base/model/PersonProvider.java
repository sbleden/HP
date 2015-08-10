package de.db.base.model;

import java.util.HashSet;
import java.util.Set;

import de.db.base.model.interfaces.IPersonProvider;

public class PersonProvider implements IPersonProvider {

	private Set<Person> persons = new HashSet<>();

	public void addPerson(Person person) {
		if (!this.persons.contains(person)) {
			this.persons.add(person);
		}
	}

	public Set<Person> getPersons() {
		return persons;
	}
}
