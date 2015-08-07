package de.db.base.model.interfaces;

import de.db.base.model.Person;

public interface ICorrelationProvider {

	Integer getCorrelation(Person person1, Person person2);

}
