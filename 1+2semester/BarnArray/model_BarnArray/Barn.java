package model_BarnArray;

public class Barn {
	private String navn;
	private int alder;
	private boolean køn; // k�n = true angiver dreng, k�n = false angiver pige
	private double[] weight;
	
	private static final int MAKS_ANTAL_DAGE = 10;
	
	public Barn(String navn, int alder, boolean køn, double[] weight) {
		this.navn = navn;
		this.alder = alder;
		this.køn = køn;
		this.weight = weight;
		weight = new double[MAKS_ANTAL_DAGE];
		
	}
	
	public double weight(int alder){
		return weight[alder];
	}
	
	public double weightComparison(){
		double sum = 0;
		double sum1 = 0;
		int i = 0;
		for(i = 0; i < weight.length-1; i++){
			sum1 = weight[i+1] - weight[i];
			if(sum1 > sum){
			sum = sum1;
			}
		}
		return sum;
	}
	
	public int getAlder() {
		return alder;
	}

	public void setAlder(int alder) {
		this.alder = alder;
	}

	public boolean isKøn() {
		return køn;
	}

	public void setKøn(boolean køn) {
		this.køn = køn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}



}
