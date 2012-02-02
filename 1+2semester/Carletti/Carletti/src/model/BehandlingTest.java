package model;

import junit.framework.Assert;

import org.junit.Test;


public class BehandlingTest {

	@Test
	public void behandlingMedGyldig(){
		Behandling behandling = new Behandling(501, "Chokolade");
		
		Assert.assertNotNull(behandling);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void behandlingIDNull(){
		Behandling behandling = new Behandling(501, null);
	}

	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void behandlingNavnNull(){
		Behandling behandling = new Behandling(0, "Chokolade");
	}
}
