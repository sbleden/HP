package de.db.base.solving;

import java.util.Hashtable;

import de.db.base.model.Person;
import de.db.base.model.Table;
import de.db.base.solving.interfaces.ISolvingResult;
import de.db.base.solving.interfaces.ITableDescription;

public class SimpleSolvingResult implements ISolvingResult {

	Hashtable<Person, Table> personTableMapping;

	public SimpleSolvingResult(Hashtable<Person, Table> personTableMapping) {
		super();
		this.personTableMapping = personTableMapping;
	}

	@Override
	public ITableDescription get(Person person) {
		return personTableMapping.get(person).getTableDescription();
	}

}
