package de.db.base.solving.provider;

import de.db.base.model.Person;

public interface IPersonWeigthDeterminer {

	public default int weigth(Person p1, Person p2) {
		return 0;
	}

}
