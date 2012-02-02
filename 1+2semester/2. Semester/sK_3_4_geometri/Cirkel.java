package sK_3_4_geometri;

public class Cirkel extends GeometriskeFigurer{
	
	public Cirkel(int x){
		super(x, 0);
	}
	
	public double beregnAreal(){
		double areal = Math.PI*Math.pow(super.getX(), 2);
		return areal;
	}
	
	

}
