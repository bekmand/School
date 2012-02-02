package service;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class ServiceTest {

	@Before
	public void forbered(){
		
		Service s = Service.getInstance();
		s.createLager();
		s.createBaand("1", 1, 5);
		s.createBaand("2", 2, 5);
		s.createBaand("3", 3, 5);
		s.createBaand("4", 4, 5);
		s.createBaand("5", 5, 5);
		
		s.createMellemvare("Psld", 324, 232);
		s.createMellemvare("Lakrids", 231, 1010);
		s.createMellemvare("Skumbananer", 101, 1001);
		s.createMellemvare("p-tærter", 120, 1002);
		s.createMellemvare("Psld", 324, 233);
		s.createMellemvare("Lakrids", 231, 1011);
		s.createMellemvare("Skumbananer", 101, 1003);
		s.createMellemvare("p-tærter", 120, 1004);
		s.createMellemvare("p-tærter", 120, 1015);
		
		s.createBehandling(242, "Drageering");
		s.createBehandling(100, "Skum");
		s.createBehandling(322, "Mint");
		
		s.createDelbehandling(10, 20, 30, "Del1", 001);
		s.createDelbehandling(20, 30, 40, "Del2", 002);
		s.createDelbehandling(10, 25, 35, "Del3", 003);
		s.createDelbehandling(19, 25, 35, "Del4", 004);
		
		s.getBehandling(242).addDelbehandling(s.getDelbehandling(001));
		s.getBehandling(242).addDelbehandling(s.getDelbehandling(002));
		s.getBehandling(242).addDelbehandling(s.getDelbehandling(003));
		s.getBehandling(100).addDelbehandling(s.getDelbehandling(003));
		s.getBehandling(100).addDelbehandling(s.getDelbehandling(002));
		s.getBehandling(322).addDelbehandling(s.getDelbehandling(002));
		s.getBehandling(322).addDelbehandling(s.getDelbehandling(004));
		
		s.setBehandlingTilMellemvare(s.getMellemvare(232), s.getBehandling(242));
		s.setBehandlingTilMellemvare(s.getMellemvare(1010), s.getBehandling(100));
		s.setBehandlingTilMellemvare(s.getMellemvare(1001), s.getBehandling(242));
		s.setBehandlingTilMellemvare(s.getMellemvare(1002), s.getBehandling(322));
		s.setBehandlingTilMellemvare(s.getMellemvare(233), s.getBehandling(242));
		s.setBehandlingTilMellemvare(s.getMellemvare(1011), s.getBehandling(100));
		s.setBehandlingTilMellemvare(s.getMellemvare(1003), s.getBehandling(322));
		s.setBehandlingTilMellemvare(s.getMellemvare(1004), s.getBehandling(322));
		s.setBehandlingTilMellemvare(s.getMellemvare(1015), s.getBehandling(100));
		
		s.afleverMellemvare(232, s.anbefaletBaandTilMellemvare(232).getBatchID());
		s.afleverMellemvare(1010, s.anbefaletBaandTilMellemvare(1010).getBatchID());
		s.afleverMellemvare(1001, s.anbefaletBaandTilMellemvare(1001).getBatchID());
		s.afleverMellemvare(1002, s.anbefaletBaandTilMellemvare(1002).getBatchID());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.afleverMellemvare(233, s.anbefaletBaandTilMellemvare(233).getBatchID());
		s.afleverMellemvare(1011, s.anbefaletBaandTilMellemvare(1011).getBatchID());
		s.afleverMellemvare(1003, s.anbefaletBaandTilMellemvare(1003).getBatchID());
		s.afleverMellemvare(1004, s.anbefaletBaandTilMellemvare(1004).getBatchID());
	}
	
	@Test
	public void getAnbefaletBaand(){
		Service s = Service.getInstance();
		
		Assert.assertEquals(s.getBaand(1), s.anbefaletBaandTilMellemvare(1015));
	}
}
