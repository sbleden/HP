// package de.db.base;
//
// import org.junit.Test;
//
// import de.db.base.model.interfaces.IRoomDescriptor;
// import de.db.base.solving.InvalidInputException;
// import de.db.base.solving.SolverBuilder;
// import de.db.base.solving.interfaces.ISolver;
// import de.db.base.solving.interfaces.ISolvingResult;
// import de.db.base.testscene1.Scene1;
// import junit.framework.TestCase;
//
// public class IntegrationTests extends TestCase {
//
// @Test
// public void testSimple() throws InvalidInputException {
// Scene1 scene1 = new Scene1();
// SolverBuilder builder = new SolverBuilder();
// IRoomDescriptor roomDescriptor = new
// MultipleSingleTableRoomCreator().createMultipleSingleTableInCircle(5, 6);
// ISolver solver = builder.create(scene1.getPersonProvider(),
// scene1.getWeigthDeterminer(), roomDescriptor);
// ISolvingResult result = solver.calculate();
// System.out.println(result);
// }
// }
