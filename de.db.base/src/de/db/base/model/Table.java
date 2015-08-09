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
		if (isFull()) {
			throw new IllegalStateException();
		}
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
		return persons.size() >= tableDescription.getNumberOfPlaces();
	}

	@Override
	public String toString() {
		return "Table [persons=" + persons + "]";
	}

}
