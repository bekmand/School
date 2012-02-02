package service;

import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import model.*;

public class Service {
	private static Dao dao;

	private static Service instans;

	public static Service getInstance() {
		if (instans == null) {
			instans = new Service();
		}
		return instans;
	}

	private Service() {
		dao = Dao.getInstance();
	}

	// Create
	public void createMellemvare(String navn, int antal, int batchID) {
		Mellemvare mellemvare = new Mellemvare(navn, antal, batchID);

		dao.storeMellemvare(mellemvare);
	}

	public void setBehandlingTilMellemvare(Mellemvare mellemvare,
			Behandling behandling) {
		mellemvare.setBehandling(behandling);
	}

	public void createBehandling(int batchID, String navn) {
		Behandling behandling = new Behandling(batchID, navn);
		Dao.storeBehandling(behandling);
	}

	public void createDelbehandling(int mins, int ideal, int max, String navn,
			int batchID) {
		Delbehandling delbehandling = new Delbehandling(mins, ideal, max, navn,
				batchID);
		Dao.storeDelbehandling(delbehandling);
	}

	public void createLager() {
		Lager nyLager = Lager.getInstance();
		dao.storeLager(nyLager);
	}

	public void createBaand(String navn, int batchID, int kapacitet) {
		Baand baand = new Baand(navn, batchID, kapacitet);
		Dao.storeBaand(baand);
	}

	// Delete

	public void deleteMellemvare(Mellemvare mellemvare) {
		if (mellemvare.getBaand() == null) {
			Dao.removeMellemvare(mellemvare);
		} else {

		}
	}

	public void deleteBehandling(Behandling behandling) {
		Dao.removeBehandling(behandling);
	}

	public void deleteDelbehandling(Delbehandling delbehandling) {
		boolean harLink = false;
		int i = 0;
		int j = 0;
		while (harLink == false && i < dao.getBehandling().size()) {
			Behandling behandling = Dao.getBehandling().get(i);
			while (harLink == false
					&& j < behandling.getDelbehandlinger().size()) {
				if (behandling.getDelbehandlinger().get(j)
						.equals(delbehandling)) {
					harLink = true;
				}
				j++;
			}
			i++;
		}
		if (harLink == true) {
			throw new RuntimeException();
		} else {
			dao.removeDelbehandling(delbehandling);
		}
	}

	public void deleteBaand(Baand baand) {
		if (baand.getMellemvarer().size() == 0) {
			Dao.removeBaand(baand);
		} else {

		}
	}

	// Update/get

	public Mellemvare getMellemvare(int batchID) {
		Mellemvare mVare = null;

		for (int i = 0; i < dao.getInstance().getMellemvare().size(); i++) {
			if (dao.getInstance().getMellemvare().get(i).getBatchID() == batchID) {
				mVare = dao.getInstance().getMellemvare().get(i);
			}
		}

		return mVare;
	}

	public List<Mellemvare> getAlleMellemvarer() {
		return dao.getInstance().getMellemvare();
	}

	public List<Mellemvare> getAlleMellemvarerPåBånd() {
		List<Mellemvare> list = new ArrayList<Mellemvare>();

		for (int i = 0; i < dao.getBaand().size(); i++) {
			for (int j = 0; j < dao.getBaand().get(i).getMellemvarer().size(); j++) {
				list.add(dao.getBaand().get(i).getMellemvarer().get(j));
			}
		}
		return list;
	}

	public Behandling getBehandling(int batchID) {
		Behandling bHand = null;

		for (int i = 0; i < dao.getInstance().getBehandling().size(); i++) {
			if (dao.getInstance().getBehandling().get(i).getBatchID() == batchID) {
				bHand = dao.getInstance().getBehandling().get(i);
			}
		}

		return bHand;
	}

	public List<Behandling> getAlleBehandlinger() {
		return dao.getInstance().getBehandling();
	}

	public Delbehandling getDelbehandling(int batchID) {
		Delbehandling dBelHand = null;

		for (int i = 0; i < dao.getInstance().getDelbehandling().size(); i++) {
			if (dao.getInstance().getDelbehandling().get(i).getBatchID() == batchID)
				dBelHand = dao.getInstance().getDelbehandling().get(i);
		}

		return dBelHand;
	}

	public List<Delbehandling> getAlleDelbehandlinger() {
		return dao.getInstance().getDelbehandling();
	}

	public Lager getLager() {
		return dao.getInstance().getLager();
	}

	public Baand getBaand(int batchID) {
		Baand baand = null;

		for (int i = 0; i < dao.getInstance().getBaand().size(); i++) {
			if (dao.getInstance().getBaand().get(i).getBatchID() == batchID)
				baand = dao.getInstance().getBaand().get(i);
		}
		return baand;
	}

	public List<Baand> getAlleBaand() {
		return dao.getInstance().getBaand();
	}

	public void updateBehandling(Behandling behandling, String navn, int batchID) {
		behandling.setNavn(navn);
		behandling.setBatchID(batchID);
	}

	public void updateDelbehandling(Delbehandling delbehandling, int mins,
			int ideal, int max, String navn, int batchID) {
		delbehandling.setMinimumsTørretid(mins);
		delbehandling.setIdealTørretid(ideal);
		delbehandling.setMaximalTørretid(max);
		delbehandling.setNavn(navn);
		delbehandling.setBatchID(batchID);
	}

	public void updateBaand(Baand baand, String navn, int batchID, int kapacitet) {
		baand.setNavn(navn);
		baand.setKapacitet(kapacitet);
		baand.setBatchID(batchID);
	}

	public void updateMellemvare(Mellemvare mellemvare, String navn, int antal,
			int batchID) {
		mellemvare.setNavn(navn);
		mellemvare.setAntal(antal);
		mellemvare.setBatchID(batchID);
	}

	public void afhentMellemvare(int batchID) {
		Mellemvare mellemvare = getMellemvare(batchID);
		mellemvare.setBaand(null);

	}

	public void afleverMellemvare(int mBatchID, int bBatchID) {
		Mellemvare mellemvare = getMellemvare(mBatchID);
		Baand baand = getBaand(bBatchID);

		if (baand.getKapacitet() == baand.getMellemvarer().size()) {

		} else {
			mellemvare.setBaand(baand);
			int count = mellemvare.getBehandling().getCounter();
			Delbehandling delbehandling = mellemvare.getBehandling()
					.getDelbehandlinger().get(count);

			tørring toerreTid = new tørring(
					(mellemvare.getBatchID() + mellemvare.getToerretider()
							.size()), mellemvare, delbehandling);
			mellemvare.addTørretid(toerreTid);
		}
	}

	public void fjernAlleDelbehandlngerFraBehandling(Behandling behandling) {
		int x = behandling.getDelbehandlinger().size();
		while (x != 0) {
			behandling.removeDelbehandling(behandling.getDelbehandlinger().get(
					x - 1));
			x--;
		}
	}

	public int færdigbehandletEllerEj(Mellemvare mellemvare) {
		if (mellemvare.getToerretider().size() == mellemvare.getBehandling()
				.getDelbehandlinger().size()) {
			return 1;
		} else {
			return 0;
		}
	}

	public Baand anbefaletBaandTilMellemvare(int mellemvareID) {
		Baand anbefaletBaand = null;
		Baand kandidat = null;
		Mellemvare m1 = getMellemvare(mellemvareID);
		long nyToerretidIdeal = m1.getToerretider()
				.get(m1.getToerretider().size()).getDelbehandling()
				.getIdealTørretid();
		long nyToerretidMax = m1.getToerretider()
				.get(m1.getToerretider().size()).getDelbehandling()
				.getMaximalTørretid();
		long mindsteForskel = Long.MAX_VALUE;

		for (Baand baand : getAlleBaand()) {

			if (baand.getKapacitet() > baand.getMellemvarer().size()) {
				if (baand.getMellemvarer().size() > 0) {

					Mellemvare sidstTilfoejet = baand.getMellemvarer().get(
							baand.getMellemvarer().size() - 1);

					tørring t1 = sidstTilfoejet.getToerretider().get(
							sidstTilfoejet.getToerretider().size() - 1);

					long sidsteMaxTid = t1.getDelbehandling()
							.getMaximalTørretid();

					long nuvaerendeToerret = t1.getSekunderToerret();

					long gammelMellemvareToerretidIdeal = t1.getDelbehandling()
							.getIdealTørretid();
					long gammelMellemvareResterendeToerretidIdeal = gammelMellemvareToerretidIdeal
							- nuvaerendeToerret;
					long gammelMellemvareToerretidMaximum = t1
							.getDelbehandling().getMaximalTørretid();
					long gammelMellemvareResterendeToerretidMaximum = gammelMellemvareToerretidMaximum
							- nuvaerendeToerret;

					if (gammelMellemvareResterendeToerretidIdeal <= nyToerretidIdeal
							&& (nyToerretidIdeal - gammelMellemvareResterendeToerretidIdeal) <= mindsteForskel) {
						mindsteForskel = (nyToerretidIdeal - gammelMellemvareResterendeToerretidIdeal);
						kandidat = baand;
						if (gammelMellemvareResterendeToerretidMaximum <= nyToerretidMax) {
							anbefaletBaand = baand;
						}

					}
				} else {
					anbefaletBaand = baand;
					mindsteForskel = 0;

				}
			}
		}
		if (anbefaletBaand == null) {
			return kandidat;

		} else {
			return anbefaletBaand;

		}
	}

	public void startUp() {
		dao.storeLager(Lager.getInstance());
		createDelbehandling(19, 25, 35, "Dumle", 1253);
		createMellemvare("Psld", 324, 232);
		createBehandling(242, "Drageering");
	}

}
