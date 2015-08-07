package de.db.base.model;

import java.util.LinkedList;
import java.util.List;

import de.db.base.solving.interfaces.ITableDescription;

public class Table {

	private ITableDescription tableDescription;
	private List<Person> persons = new LinkedList<>();

	public Table(ITableDescription tableDescription) {
		super();
		this.tableDescription = tableDescription;
	}

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

	public ITableDescription getTableDescription() {
		return tableDescription;
	}

	public boolean isFull() {
		return persons.size() + 1 >= tableDescription.getNumberOfPlaces();
	}

}
