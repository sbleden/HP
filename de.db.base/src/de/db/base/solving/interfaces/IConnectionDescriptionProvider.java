package de.db.base.solving.interfaces;

import de.db.base.model.Person;

public interface IConnectionDescriptionProvider {

	IConnectionDescription getConnectionDescription(Person person1, Person person2);

}
