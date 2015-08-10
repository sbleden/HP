package de.db.base.model;

import org.junit.Test;

import de.db.base.AbstractModelTest;

public class CorrelationProviderTest extends AbstractModelTest {

	private CorrelationProvider correlationProvider;

	@Override
	protected void setUp() throws Exception {
		correlationProvider = new CorrelationProvider();
	}

	@Test
	public void testCorrelationProvider() {

		correlationProvider.addCorrelation(lisa, peter, 2);

		assertEquals(new Integer(2), correlationProvider.getCorrelation(lisa, peter));
		assertEquals(new Integer(2), correlationProvider.getCorrelation(peter, lisa));
		assertEquals(new Integer(5), correlationProvider.getCorrelation(lisa, hans));
	}
}
