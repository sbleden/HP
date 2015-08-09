package de.db.base.solving;

import java.util.HashSet;
import java.util.Hashtable;

import de.db.base.model.Person;
import de.db.base.model.Table;
import de.db.base.solving.interfaces.ISolvingResult;

public class SimpleSolvingResult implements ISolvingResult {

	protected Hashtable<Person, Table> personTableMapping;
	protected int weigth;

	public SimpleSolvingResult(Hashtable<Person, Table> personTableMapping) {
		super();
		this.personTableMapping = personTableMapping;
	}

	@Override
	public Table get(Person person) {
		return personTableMapping.get(person);
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	@Override
	public String toString() {
		return "Weigth: " + weigth + " , " + new HashSet<>(personTableMapping.values()).toString();
	}
}
