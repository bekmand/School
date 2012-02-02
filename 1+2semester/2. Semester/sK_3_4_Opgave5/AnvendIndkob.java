package sK_3_4_Opgave5;

public class AnvendIndkob {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IndkobsVogn vogn = new IndkobsVogn();
		Vare v1 = new ElArtikel(25, "5m Ledning");
		Vare v2 = new ElArtikel(45, "Han-stik");
		Vare v3 = new Vare(30, "Tandpasta");
		Vare v4 = new Fodevare(199, "Oliver Kylling");
		Vare v5 = new Spiritus(99.95, "Smirnoff Vodka");
		Vare v6 = new Spiritus(220, "Jack Daniels");

		vogn.addVare(v1);
		vogn.addVare(v2);
		vogn.addVare(v3);
		vogn.addVare(v4);
		vogn.addVare(v5);
		vogn.addVare(v6);

		vogn.udskrivBon();

	}

}
