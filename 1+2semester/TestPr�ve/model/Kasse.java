package model;

public class Kasse {
	private String kategori;
	private double pris;
	
	public Kasse(String kategori, double pris){
		this.kategori = kategori;
		this.pris = pris;
	}
	
	public String getKategori(){
		return kategori;
	}
	
	public double getPris(){
		return pris;
	}
	
	public void setKategori(String kategori){
		this.kategori = kategori;
	}
	
	public void setPris(double pris){
		this.pris = pris;
	}

}
