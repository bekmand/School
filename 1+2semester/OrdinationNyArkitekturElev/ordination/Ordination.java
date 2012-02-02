package ordination;

import java.util.GregorianCalendar;

public abstract class Ordination {
	private GregorianCalendar startDen;
	private GregorianCalendar slutDen;

	//TODO Link til L�gemiddel
	//TODO constructor (med specifikation)
	
	public GregorianCalendar getStartDen() {
		return startDen;
	}	
	public GregorianCalendar getSlutDen() {
			return slutDen;
	}
	/**
	 * Returnerer antal hele dage mellem startdato og slutdato. Begge dage inklusive.
	 * Krav: startdato<=slutdato
	 * @return antal dage ordinationen g�lder for
	 */
	public long antalDage(){
		return (slutDen.getTimeInMillis()-startDen.getTimeInMillis())/(24*60*60*1000)+1;
	}
	public String toString(){
		return startDen.get(GregorianCalendar.DATE)+"."+ (startDen.get(GregorianCalendar.MONTH)+1)+ "."+startDen.get(GregorianCalendar.YEAR);
	}
	
	// TODO: Metoder(med specifikation) til at vedligeholde link til L�gemiddel
	
	/**
	 * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
	 * @return
	 */
	public abstract double samletDosis();
	
	/**
	 * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
	 * @return
	 */
	public abstract double d�gnDosis();
}
