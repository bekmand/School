package model;

import junit.framework.Assert;

import org.junit.Test;


public class BaandTest {

	@Test
	public void opretBaandPositivKapacitet(){
		Baand b = new Baand(1, "1", 5);
		Assert.assertNotNull(b);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretBaandNegativKapacitet(){
		Baand b = new Baand(1, "1", -1);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretBaandMedNulKapacitet(){
		Baand b = new Baand(1, "1", 0);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretBaandNavnNull(){
		Baand b = new Baand(1, null, 5);
	}
}
