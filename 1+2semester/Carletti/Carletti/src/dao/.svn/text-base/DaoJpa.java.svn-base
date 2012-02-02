package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.*;


public class DaoJpa implements DAO{
	private static DaoJpa instance;
	private static Lager lager;
	private static List<Baand> baandListe = new ArrayList<Baand>();
	private static List<Mellemvare> mellemvareListe = new ArrayList<Mellemvare>();
	private static List<Behandling> behandlingsListe = new ArrayList<Behandling>();
	private static List<Delbehandling> delbehandlingsListe = new ArrayList<Delbehandling>();

	private EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	
	public static DaoJpa getInstance(){
		if(instance == null){
			instance = new DaoJpa();
		}
		return instance;
	}
	
	private DaoJpa(){
		emf = Persistence.createEntityManagerFactory("carletti");
		em = emf.createEntityManager();
		tx = em.getTransaction();

		indlaesAlleBaand();
		indlaesAlleBehandlinger();
		indlaesAlleDelbehandlinger();
		indlaesAlleMellemvarer();
	}
	
	private static void persistJPA(Object object){
		tx.begin();
		em.persist(object);
		tx.commit();
	}
	
	private static void removeJPA(Object object){
		tx.begin();
		em.remove(object);
		tx.commit();
	}

	private void indlaesAlleMellemvarer() {
		List<Mellemvare> result = em.createQuery(
				"SELECT m FROM Mellemvare m", Mellemvare.class)
				.getResultList();
		mellemvareListe.addAll(result);
	}

	private void indlaesAlleBaand() {
		List<Baand> result = em.createQuery("SELECT b FROM Baand b",
				Baand.class).getResultList();
		baandListe.addAll(result);
	}

	private void indlaesAlleBehandlinger() {
		List<Behandling> result = em.createQuery("SELECT b FROM Behandling b",
				Behandling.class).getResultList();
		behandlingsListe.addAll(result);
	}

	private void indlaesAlleDelbehandlinger() {
		List<Delbehandling> result = em.createQuery(
				"SELECT d FROM Delbehandling d", Delbehandling.class)
				.getResultList();
		delbehandlingsListe.addAll(result);
	}
	
	public static Lager getLager(){
		return lager;
	}
	
	public List<Baand> getBaand(){
		return new ArrayList<Baand>(baandListe);
	}
	
	public List<Mellemvare> getMellemvare(){
		return new ArrayList<Mellemvare>(mellemvareListe);
	}
	
	public List<Behandling> getBehandling(){
		return new ArrayList<Behandling>(behandlingsListe);
	}
	
	public List<Delbehandling> getDelbehandling(){
		return new ArrayList<Delbehandling>(delbehandlingsListe);
	}
	
	public Lager storeLager(Lager lageret) {
		lager = lageret;
		persistJPA(lager);
		return lager;
	}
	
	public Baand storeBaand(Baand baand){
		if (!baandListe.contains(baand)) {
			baandListe.add(baand);
		}
		persistJPA(baand);
		return baand;
	}
	
	public Mellemvare storeMellemvare(Mellemvare mellemvare){
		if (!mellemvareListe.contains(mellemvare)) {
			mellemvareListe.add(mellemvare);
		}
		persistJPA(mellemvare);
		return mellemvare;
	}
	
	public Behandling storeBehandling(Behandling behandling){
		if (!behandlingsListe.contains(behandling)) {
			behandlingsListe.add(behandling);
		}
		persistJPA(behandling);
		return behandling;
	}
	
	public Delbehandling storeDelbehandling(Delbehandling delbehandling){
		if (!delbehandlingsListe.contains(delbehandling)) {
			delbehandlingsListe.add(delbehandling);
		}
		persistJPA(delbehandling);
		return delbehandling;
	}
	
	public Baand removeBaand(Baand baand){
		baandListe.remove(baand);
		removeJPA(baand);
		return baand;
	}
	
	public Mellemvare removeMellemvare(Mellemvare mellemvare){
		mellemvareListe.remove(mellemvare);
		removeJPA(mellemvare);
		return mellemvare;
	}
	
	public Behandling removeBehandling(Behandling behandling){
		behandlingsListe.remove(behandling);
		removeJPA(behandling);
		return behandling;
	}
	
	public Delbehandling removeDelbehandling(Delbehandling delbehandling){
		delbehandlingsListe.remove(delbehandling);
		removeJPA(delbehandling);
		return delbehandling;
	}
}
