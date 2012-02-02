package model;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MellemvareTest {

	@Test
	public void opretMellemvareMedGyldigÆkvi() {
		Mellemvare m = new Mellemvare("P-tærter", 10, 202);
		
		Assert.assertNotNull(m);
	}
	
	@Test(expected = RuntimeException.class)
	public void opretMellemvareAntalNul(){
		Mellemvare m = new Mellemvare("P-tørter", 0, 202);
	}
	
	@Test(expected = RuntimeException.class)
	public void opretMellemvareAntalNegativ(){
		Mellemvare m = new Mellemvare("P-tørter", -5, 202);
	}
	
	@Test(expected = RuntimeException.class)
	public void opretMellemvareNavnNull(){
		Mellemvare m = new Mellemvare(null, 10, 202);
	}
	
	@Test(expected = RuntimeException.class)
	public void opretMellemvareIDNul(){
		Mellemvare m = new Mellemvare("P-tørter", 10, 0);
	}

}
