package model;

public class Deltager {
	private String navn;
	private int nr;
	private String addresse;
	private String by;
	private String land;
	private int tlf;
	private String firmaNavn;
	private int firmaTlf;

	public Deltager(String navn, int nr, String addresse, String by, String land, int tlf){
		this.navn = navn;
		this.nr = nr;
		this.addresse = addresse;
		this.by = by;
		this.land = land;
		this.tlf = tlf;
	}
	
	
}
