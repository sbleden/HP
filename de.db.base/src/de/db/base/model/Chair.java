package de.db.base.model;

import java.util.ArrayList;
import java.util.List;

public class Chair {

	private List<Person> persons = new ArrayList<>();

	public void addPerson(Person person) {
		this.persons.add(person);
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
