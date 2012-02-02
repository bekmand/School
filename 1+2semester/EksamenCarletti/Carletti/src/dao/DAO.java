package dao;

import java.util.List;

import model.*;


public interface DAO {
	List<Baand> getBaand();
	List<Mellemvare> getMellemvare();
	List<Behandling> getBehandling();
	List<Delbehandling> getDelbehandling();
	Mellemvare removeMellemvare(Mellemvare mellemvare);
	Baand removeBaand(Baand baand);
	Behandling removeBehandling(Behandling behandling);
	Delbehandling removeDelbehandling(Delbehandling delbehandling);
	Mellemvare storeMellemvare(Mellemvare mellemvare);
	Baand storeBaand(Baand baand);
	Behandling storeBehandling(Behandling behandling);
	Delbehandling storeDelbehandling(Delbehandling delbehandling);
	Lager storeLager(Lager lager);
	

}
