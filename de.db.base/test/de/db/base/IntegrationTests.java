package de.db.base;

import org.junit.Test;

import de.db.base.model.interfaces.ICorrelationProvider;
import de.db.base.solving.SolverBuilder;
import de.db.base.solving.interfaces.IRoomDescriptor;
import de.db.base.solving.provider.PersonByRoomDescriptorProvider;
import de.db.base.solving.provider.SimpleWeightDeterminer;
import junit.framework.TestCase;

public class IntegrationTests extends TestCase {

	@Test
	public void testSimple() {
		SolverBuilder builder = new SolverBuilder();
		IRoomDescriptor roomDescriptor = null;
		ICorrelationProvider correlationProvider = null;
		builder.create(new PersonByRoomDescriptorProvider(roomDescriptor),
				new SimpleWeightDeterminer(correlationProvider), roomDescriptor);
	}
}
