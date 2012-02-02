package sK_3_4_geometri;

public class Rektangle extends GeometriskeFigurer{
	
	public Rektangle(int x, int y){
		super(x, y);
	}	
	
	@Override
	public double beregnAreal(){
		return x * y / 2;
	}
}
