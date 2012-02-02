package model;

import junit.framework.Assert;

import org.junit.Test;


public class DelbehandlingTest {

	@Test
	public void opretDelbehandling(){
		Delbehandling d = new Delbehandling(10, 20, 30, "Drageering", 383);
		
		Assert.assertNotNull(d);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretDelbehandlingNegativMinToerretid(){
		Delbehandling d = new Delbehandling(-10, 20, 30, "Drageering", 383);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretDelbehandlingMindstIdealToerretid(){
		Delbehandling d = new Delbehandling(20, 10, 30, "Drageering", 383);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretDelbehandlingStørstIdealToerretid(){
		Delbehandling d = new Delbehandling(10, 30, 20, "Drageering", 383);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretDelbehandlingMaxToerretidErMindst(){
		Delbehandling d = new Delbehandling(20, 30, 10, "Drageering", 383);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretDelbehandlingIDNul(){
		Delbehandling d = new Delbehandling(10, 20, 30, "Drageering", 0);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void opretDelbehandlingNavnNull(){
		Delbehandling d = new Delbehandling(10, 20, 30, null, 383);
	}
}
