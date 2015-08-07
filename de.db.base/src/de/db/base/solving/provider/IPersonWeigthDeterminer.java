package de.db.base.solving.provider;

import de.db.base.model.Person;
import de.db.base.solving.interfaces.IConnectionDescription;

public interface IPersonWeigthDeterminer {

	public int weigth(IConnectionDescription description, Person p1, Person p2);

}
