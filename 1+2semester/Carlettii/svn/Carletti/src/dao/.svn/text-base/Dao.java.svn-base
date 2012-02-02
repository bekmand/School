package dao;

import java.util.ArrayList;
import java.util.List;

import model.*;


public class Dao {
	private static Dao instance;
	private static Lager lager;
	private static List<Baand> baandListe = new ArrayList<Baand>();
	private static List<Mellemvare> mellemvareListe = new ArrayList<Mellemvare>();
	private static List<Behandling> behandlingsListe = new ArrayList<Behandling>();
	private static List<Delbehandling> delbehandlingsListe = new ArrayList<Delbehandling>();
	
	public static Dao getInstance(){
		if(instance == null){
			instance = new Dao();
		}
		return instance;
	}
	
	public static Lager getLager(){
		return lager;
	}
	
	public static List<Baand> getBaand(){
		return new ArrayList<Baand>(baandListe);
	}
	
	public static List<Mellemvare> getMellemvare(){
		return new ArrayList<Mellemvare>(mellemvareListe);
	}
	
	public static List<Behandling> getBehandling(){
		return new ArrayList<Behandling>(behandlingsListe);
	}
	
	public static List<Delbehandling> getDelbehandling(){
		return new ArrayList<Delbehandling>(delbehandlingsListe);
	}
	
	public Lager storeLager(Lager lageret) {
		lager = lageret;
		return lager;
	}
	
	public static Baand storeBaand(Baand baand){
		baandListe.add(baand);
		return baand;
	}
	
	public Mellemvare storeMellemvare(Mellemvare mellemvare){
		mellemvareListe.add(mellemvare);
		return mellemvare;
	}
	
	public static Behandling storeBehandling(Behandling behandling){
		behandlingsListe.add(behandling);
		return behandling;
	}
	
	public static Delbehandling storeDelbehandling(Delbehandling delbehandling){
		delbehandlingsListe.add(delbehandling);
		return delbehandling;
	}
	
	public static Baand removeBaand(Baand baand){
		baandListe.remove(baand);
		return baand;
	}
	
	public static Mellemvare removeMellemvare(Mellemvare mellemvare){
		mellemvareListe.remove(mellemvare);
		return mellemvare;
	}
	
	public static Behandling removeBehandling(Behandling behandling){
		behandlingsListe.remove(behandling);
		return behandling;
	}
	
	public static Delbehandling removeDelbehandling(Delbehandling delbehandling){
		delbehandlingsListe.remove(delbehandling);
		return delbehandling;
	}
}
