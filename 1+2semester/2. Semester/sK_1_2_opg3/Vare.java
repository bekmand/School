package sK_1_2_opg3;

public class Vare {
	private int nummer;

	private String navn;

	private double stkPris;

	private int antalPaaLager;

	public Vare(int nummer, String navn, double stkPris) {
		this.nummer = nummer;
		this.navn = navn;
		this.stkPris = stkPris;
		antalPaaLager = 0;
	}

	public int getNummer() {
		return nummer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getStkPris() {
		return stkPris;
	}

	public void setStkPris(double stkPris) {
		this.stkPris = stkPris;
	}

	public int getAntalPaaLager() {
		return antalPaaLager;
	}

	public void setAntalPaaLager(int antalPaaLager) {
		this.antalPaaLager = antalPaaLager;
	}

}
