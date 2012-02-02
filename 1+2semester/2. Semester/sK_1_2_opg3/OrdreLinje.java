package sK_1_2_opg3;

public class OrdreLinje {
	private int linieNr;

	private int antalStk;

	private Vare vare;

	OrdreLinje(int linieNr, int antalStk, Vare vare) {
		this.linieNr = linieNr;
		this.antalStk = antalStk;
		this.vare = vare;

	}

	public int getLinieNr() {
		return linieNr;
	}

	public int getAntalStk() {
		return antalStk;
	}
	public Vare getVare(){
		return vare;
	}
	public double pris(){
		return antalStk * vare.getStkPris();
	}

}
