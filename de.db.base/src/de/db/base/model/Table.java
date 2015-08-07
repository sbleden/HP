package de.db.base.model;

import java.util.LinkedList;
import java.util.List;

public class Table {

	private List<Person> persons = new LinkedList<>();

	public void addPerson(Person person) {
		this.persons.add(person);
		person.setTable(this);
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
		persons.stream().forEach(person -> person.setTable(this));
	}

}
