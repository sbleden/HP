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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tableDescription == null) ? 0 : tableDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (tableDescription == null) {
			if (other.tableDescription != null)
				return false;
		} else if (!tableDescription.equals(other.tableDescription))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Table [persons=" + persons + "]";
	}

}
