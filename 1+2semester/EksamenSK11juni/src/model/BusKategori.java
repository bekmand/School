package model;

public class BusKategori {
	private String kategori;
	private int basisPris;
	private int kmPris;
	
	public BusKategori(String kategori, int basisPris, int kmPris){
		this.kategori = kategori;
		this.basisPris = basisPris;
		this.kmPris = kmPris;
	}
	
	//Getter & setters ****
	
	public String getKategori(){
		return kategori;
	}
	
	public int getBasisPris(){
		return basisPris;
	}
	
	public int getKmPris(){
		return kmPris;
	}
	
	public void setKategori(String kategori){
		this.kategori = kategori;
	}
	
	public void setBasisPris(int basisPris){
		this.basisPris = basisPris;
	}
	
	public void setKmPris(int kmPris){
		this.kmPris = kmPris;
	}
}
