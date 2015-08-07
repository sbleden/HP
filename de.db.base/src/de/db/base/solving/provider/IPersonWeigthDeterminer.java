package de.db.base.solving.provider;

import de.db.base.model.Person;
import de.db.base.solving.interfaces.IConnectionDescription;

public interface IPersonWeigthDeterminer {

	public default int weigth(IConnectionDescription description, Person p1, Person p2) {
		return 0;
	}

}
