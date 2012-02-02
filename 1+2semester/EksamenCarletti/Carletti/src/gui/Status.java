package gui;

import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import service.Subject;


public class Status implements Subject {

	private Set<Observer> observers;

	public Status(){
		observers = new HashSet<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);

	}

	@Override
	public void notifyObserver() {
		Iterator<Observer> itr = observers.iterator();
		while (itr.hasNext()) {
			Observer o = itr.next();
			o.update();
		}

	}
}