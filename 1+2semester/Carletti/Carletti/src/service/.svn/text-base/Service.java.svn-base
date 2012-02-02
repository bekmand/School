package service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.DaoJpa;
import model.*;

public class Service {
	private static DaoJpa dao;

	private static Service instans;

	public static Service getInstance() {
		if (instans == null) {
			instans = new Service();
		}
		return instans;
	}

	private Service() {
		dao = DaoJpa.getInstance();
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
		dao.storeBehandling(behandling);
	}

	public void createDelbehandling(int mins, int ideal, int max, String navn,
			int batchID) {
		Delbehandling delbehandling = new Delbehandling(mins, ideal, max, navn,
				batchID);
		dao.storeDelbehandling(delbehandling);
	}

	public void createLager() {
		Lager nyLager = Lager.getInstance();
		dao.storeLager(nyLager);
	}

	public void createBaand(String navn, int batchID, int kapacitet) {
		Baand baand = new Baand(batchID, navn, kapacitet);
		dao.storeBaand(baand);
		DaoJpa.getLager().addLagerBaand(baand);
	}

	// Delete

	public void deleteMellemvare(Mellemvare mellemvare) {
		if (mellemvare.getBaand() == null) {
			dao.removeMellemvare(mellemvare);
		} else {

		}
	}

	public void deleteBehandling(Behandling behandling) {
		dao.removeBehandling(behandling);
	}

	public void deleteDelbehandling(Delbehandling delbehandling) {
		boolean harLink = false;
		int i = 0;
		int j = 0;
		while (harLink == false && i < dao.getBehandling().size()) {
			Behandling behandling = dao.getBehandling().get(i);
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
			dao.removeBaand(baand);
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
		mellemvare.getToerretider().get(mellemvare.getToerretider().size()-1).setTørringAfsluttet(new GregorianCalendar());
		mellemvare.setBaand(null);

	}

	public void afleverMellemvare(int mBatchID, int bBatchID) {
		Mellemvare mellemvare = getMellemvare(mBatchID);
		Baand baand = getBaand(bBatchID);

		if (baand.getKapacitet() == baand.getMellemvarer().size()) {

		} else {
			mellemvare.setBaand(baand);
			int count = mellemvare.getToerretider().size();
			Delbehandling delbehandling = mellemvare.getBehandling()
					.getDelbehandlinger().get(count);

			tørring toerreTid = new tørring(
					(mellemvare.getBatchID() + mellemvare.getToerretider()
							.size()), mellemvare, delbehandling);
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
		long nyToerretidIdeal = m1.getBehandling().getDelbehandlinger().get(m1.getToerretider().size()).getIdealTørretid();
				
		long nyToerretidMax = m1.getBehandling().getDelbehandlinger().get(m1.getToerretider().size()).getMaximalTørretid();
		
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
		createLager();
		createBaand("1", 1, 5);
		createBaand("2", 2, 5);
		createBaand("3", 3, 5);
		createBaand("4", 4, 5);
		createBaand("5", 5, 5);
		
		createMellemvare("Psld", 324, 232);
		createMellemvare("Lakrids", 231, 1010);
		createMellemvare("Skumbananer", 101, 1001);
		createMellemvare("p-tærter", 120, 1002);
		createMellemvare("Psld", 324, 233);
		createMellemvare("Lakrids", 231, 1011);
		createMellemvare("Skumbananer", 101, 1003);
		createMellemvare("p-tærter", 120, 1004);
		createMellemvare("Psld", 324, 234);
		createMellemvare("Lakrids", 231, 1012);
		createMellemvare("Skumbananer", 101, 1005);
		createMellemvare("p-tærter", 120, 1006);
		createMellemvare("Psld", 324, 235);
		createMellemvare("Lakrids", 231, 1013);
		createMellemvare("Skumbananer", 101, 1007);
		createMellemvare("p-tærter", 120, 1008);
		createMellemvare("Psld", 324, 236);
		createMellemvare("Lakrids", 231, 1014);
		createMellemvare("Skumbananer", 101, 1009);
		createMellemvare("p-tærter", 120, 1015);
		
		createBehandling(242, "Drageering");
		createBehandling(100, "Skum");
		createBehandling(322, "Mint");
		
		createDelbehandling(10, 20, 30, "Del1", 001);
		createDelbehandling(20, 30, 40, "Del2", 002);
		createDelbehandling(10, 25, 35, "Del3", 003);
		createDelbehandling(19, 25, 35, "Del4", 004);
		
		getBehandling(242).addDelbehandling(getDelbehandling(001));
		getBehandling(242).addDelbehandling(getDelbehandling(002));
		getBehandling(242).addDelbehandling(getDelbehandling(003));
		getBehandling(100).addDelbehandling(getDelbehandling(003));
		getBehandling(100).addDelbehandling(getDelbehandling(002));
		getBehandling(322).addDelbehandling(getDelbehandling(002));
		getBehandling(322).addDelbehandling(getDelbehandling(004));
		
		setBehandlingTilMellemvare(getMellemvare(232), getBehandling(242));
		setBehandlingTilMellemvare(getMellemvare(1010), getBehandling(100));
		setBehandlingTilMellemvare(getMellemvare(1001), getBehandling(242));
		setBehandlingTilMellemvare(getMellemvare(1002), getBehandling(322));
		setBehandlingTilMellemvare(getMellemvare(233), getBehandling(242));
		setBehandlingTilMellemvare(getMellemvare(1011), getBehandling(100));
		setBehandlingTilMellemvare(getMellemvare(1003), getBehandling(322));
		setBehandlingTilMellemvare(getMellemvare(1004), getBehandling(322));
		setBehandlingTilMellemvare(getMellemvare(234), getBehandling(100));
		setBehandlingTilMellemvare(getMellemvare(1012), getBehandling(242));
		setBehandlingTilMellemvare(getMellemvare(1005), getBehandling(322));
		setBehandlingTilMellemvare(getMellemvare(1006), getBehandling(100));
		setBehandlingTilMellemvare(getMellemvare(235), getBehandling(242));
		setBehandlingTilMellemvare(getMellemvare(1013), getBehandling(100));
		setBehandlingTilMellemvare(getMellemvare(1007), getBehandling(322));
		setBehandlingTilMellemvare(getMellemvare(1008), getBehandling(242));
		setBehandlingTilMellemvare(getMellemvare(236), getBehandling(322));
		setBehandlingTilMellemvare(getMellemvare(1014), getBehandling(242));
		setBehandlingTilMellemvare(getMellemvare(1009), getBehandling(322));
		setBehandlingTilMellemvare(getMellemvare(1015), getBehandling(242));
		
		afleverMellemvare(232, anbefaletBaandTilMellemvare(232).getBatchID());
		afleverMellemvare(1010, anbefaletBaandTilMellemvare(1010).getBatchID());
		afleverMellemvare(1001, anbefaletBaandTilMellemvare(1001).getBatchID());
		afleverMellemvare(1002, anbefaletBaandTilMellemvare(1002).getBatchID());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		afleverMellemvare(233, anbefaletBaandTilMellemvare(233).getBatchID());
		afleverMellemvare(1011, anbefaletBaandTilMellemvare(1011).getBatchID());
		afleverMellemvare(1003, anbefaletBaandTilMellemvare(1003).getBatchID());
		afleverMellemvare(1004, anbefaletBaandTilMellemvare(1004).getBatchID());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		afleverMellemvare(1012, anbefaletBaandTilMellemvare(1012).getBatchID());
		afleverMellemvare(1005, anbefaletBaandTilMellemvare(1005).getBatchID());
		afleverMellemvare(1006, anbefaletBaandTilMellemvare(1006).getBatchID());
		afleverMellemvare(1007, anbefaletBaandTilMellemvare(1007).getBatchID());
		afleverMellemvare(1008, anbefaletBaandTilMellemvare(1008).getBatchID());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		afleverMellemvare(234, anbefaletBaandTilMellemvare(234).getBatchID());
		afleverMellemvare(235, anbefaletBaandTilMellemvare(235).getBatchID());
		afleverMellemvare(1013, anbefaletBaandTilMellemvare(1013).getBatchID());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		afleverMellemvare(236, anbefaletBaandTilMellemvare(236).getBatchID());
		afleverMellemvare(1009, anbefaletBaandTilMellemvare(1009).getBatchID());
		afleverMellemvare(1014, anbefaletBaandTilMellemvare(1014).getBatchID());
		afleverMellemvare(1015, anbefaletBaandTilMellemvare(1015).getBatchID());
		
	}

}
