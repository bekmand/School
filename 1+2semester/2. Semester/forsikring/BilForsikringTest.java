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
	public void testSetGrundp�mie() {
//		fail("Not yet implemented");
		
	}

	@Test(expected = RunTimeException)
	public void testBeregnPr�mie() {
//		fail("Not yet implemented");
		biltest = new BilForsikring();
		biltest.setGrundp�mie(100);
		
		assertEquals(125, biltest.beregnPr�mie(22, false, 2), 0.1);
		assertEquals(118.75, biltest.beregnPr�mie(22, true, 2), 0.1);
		
		assertEquals(100, biltest.beregnPr�mie(30, false, 1), 0.1);
		assertEquals(95, biltest.beregnPr�mie(30, true, 1), 0.1);
		
		assertEquals(85, biltest.beregnPr�mie(30, false, 4), 0.1);
		assertEquals(106.25, biltest.beregnPr�mie(25, false, 4), 0.1);
		
		assertEquals(80.75, biltest.beregnPr�mie(30, true, 4), 0.1);
		assertEquals(100.9375, biltest.beregnPr�mie(25, true, 4), 0.1);
		
		assertEquals(75, biltest.beregnPr�mie(30, false, 7), 0.1);
		assertEquals(93.75, biltest.beregnPr�mie(25, false, 7), 0.1);
		
		assertEquals(71.25, biltest.beregnPr�mie(30, true, 7), 0.1);
		assertEquals(89.0625, biltest.beregnPr�mie(22, true, 7), 0.1);
		
		assertEquals(65, biltest.beregnPr�mie(30, false, 9), 0.1);
		assertEquals(81.25, biltest.beregnPr�mie(22, false, 9), 0.1);
		
		assertEquals(61.75, biltest.beregnPr�mie(30, true, 9), 0.1);
		assertEquals(77.1875, biltest.beregnPr�mie(22, true, 9), 0.1);
	}

}
