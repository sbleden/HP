package de.db.base;

import de.db.base.model.Person;
import junit.framework.TestCase;

public abstract class AbstractModelTest extends TestCase {

	protected Person lisa = new Person("Lisa");
	protected Person peter = new Person("Peter");
	protected Person hans = new Person("Hans");
}
