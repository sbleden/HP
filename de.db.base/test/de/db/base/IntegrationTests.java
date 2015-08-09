package de.db.base;

import org.junit.Test;

import de.db.base.solving.SolverBuilder;
import de.db.base.solving.interfaces.IRoomDescriptor;
import de.db.base.testscene1.Scene1;
import junit.framework.TestCase;

public class IntegrationTests extends TestCase {

	@Test
	public void testSimple() {
		Scene1 scene1 = new Scene1();
		SolverBuilder builder = new SolverBuilder();
		IRoomDescriptor roomDescriptor = new MultipleSingleTableRoomCreator().createMultipleSingleTableInCircle(5, 6);
		builder.create(scene1.getPersonProvider(), scene1.getWeigthDeterminer(), roomDescriptor);
	}
}
