package sK_3_4_geometri;

public abstract class GeometriskeFigurer {
	
	private int x;
	private int y;
	
//	højde og bredde 
	
	
	public GeometriskeFigurer(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void parallelforskyd(double increment){
		this.x += increment;
		this.y += increment;
	}
	
	public double beregnAreal(){
		return x * y;
	}
	
	public double getX(){
		return this.x;
	}
	public void setX(int x){
		this.x = x;
	}
	public double getY(){
		return this.y;
	}
	public void setY(int y){
		this.y = y;
	}
	
}
