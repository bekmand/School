package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gui.Observer;

import javax.swing.SwingWorker;

import model.Baand;
import model.Delbehandling;
import model.Enum.appState;
import model.Mellemvare;
import model.tørring;

public class TimeManager extends SwingWorker<Void, Void> implements Subject {

	private Set<Observer> observer;

	public static void start() {
		getInstance().execute();
	}

	private static TimeManager instance;

	public static TimeManager getInstance() {
		if (instance == null) {
			instance = new TimeManager();
		}
		return instance;
	}

	private TimeManager() {
		observer = new HashSet<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observer.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		observer.remove(o);

	}

	@Override
	public void notifyObserver() {
		for (Observer o : observer) {
			o.update();
		}

	}

	@Override
	protected Void doInBackground() throws Exception {
		while (!isCancelled()) {

			boolean found = false;

			List<Baand> baand = Service.getInstance().getAlleBaand();

			for (Baand b : baand) {

				for (Mellemvare m : b.getMellemvarer()) {

					tørring t = null;

					if (m.getToerretider().size() != 0) {
						t = m.getToerretider().get(
								m.getToerretider().size() - 1);
					}

					if (t != null) {
						Delbehandling delbehandling = t.getDelbehandling();

						long sekunderToerret = t.getSekunderToerret();

						appState e = t.getStatus();

						if (sekunderToerret < delbehandling
								.getMinimumsTørretid()) {
							e = appState.FORKORT;
						} else if (sekunderToerret < delbehandling
								.getIdealTørretid()) {
							e = appState.MINTID;
						} else if (sekunderToerret < delbehandling
								.getMaximalTørretid()) {
							e = appState.IDEALTID;
						} else {
							e = appState.FORGAMMEL;

						}

						if (e != t.getStatus()) {
							t.setStatus(e);

							found = true;
						}
					}
				}

			}
			if (found) {
				notifyObserver();
			}
		}
		Thread.sleep(1000);

		return null;
	}

}
