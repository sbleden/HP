package de.db.base.solving.provider;

import java.util.HashSet;
import java.util.Set;

import de.db.base.model.Person;
import de.db.base.solving.interfaces.IRoomDescriptor;

public class PersonByRoomDescriptorProvider implements IPersonProvider {

	private IRoomDescriptor roomDescriptor;

	public PersonByRoomDescriptorProvider(IRoomDescriptor roomDescriptor) {
		this.roomDescriptor = roomDescriptor;
	}

	public Set<Person> getPersons() {
		Set<Person> persons = new HashSet<>();
		roomDescriptor.getTables().forEach(t -> persons.addAll(t.getPersons()));
		return persons;
	}
}
