package forsikring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BilForsikringTest {
	private BilForsikring biltest;

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSetGrundpæmie() {
//		fail("Not yet implemented");
		
	}

	@Test(expected = RunTimeException)
	public void testBeregnPræmie() {
//		fail("Not yet implemented");
		biltest = new BilForsikring();
		biltest.setGrundpæmie(100);
		
		assertEquals(125, biltest.beregnPræmie(22, false, 2), 0.1);
		assertEquals(118.75, biltest.beregnPræmie(22, true, 2), 0.1);
		
		assertEquals(100, biltest.beregnPræmie(30, false, 1), 0.1);
		assertEquals(95, biltest.beregnPræmie(30, true, 1), 0.1);
		
		assertEquals(85, biltest.beregnPræmie(30, false, 4), 0.1);
		assertEquals(106.25, biltest.beregnPræmie(25, false, 4), 0.1);
		
		assertEquals(80.75, biltest.beregnPræmie(30, true, 4), 0.1);
		assertEquals(100.9375, biltest.beregnPræmie(25, true, 4), 0.1);
		
		assertEquals(75, biltest.beregnPræmie(30, false, 7), 0.1);
		assertEquals(93.75, biltest.beregnPræmie(25, false, 7), 0.1);
		
		assertEquals(71.25, biltest.beregnPræmie(30, true, 7), 0.1);
		assertEquals(89.0625, biltest.beregnPræmie(22, true, 7), 0.1);
		
		assertEquals(65, biltest.beregnPræmie(30, false, 9), 0.1);
		assertEquals(81.25, biltest.beregnPræmie(22, false, 9), 0.1);
		
		assertEquals(61.75, biltest.beregnPræmie(30, true, 9), 0.1);
		assertEquals(77.1875, biltest.beregnPræmie(22, true, 9), 0.1);
	}

}
