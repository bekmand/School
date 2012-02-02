package Singleton;

public class counter {
	private static counter instance = new counter();
	private int value = 0;
	
	private counter() {}

	public static counter getInstance(){
		if(instance == null){
			instance = new counter();
		}
		return instance;
	}
	
	public void count(){
		this.value++;
	}
	
	public void times2(){
		this.value = 2*this.value;
	}
	
	public void zero(){
		this.value = 0;
	}
	
	public int getValue(){
		return this.value;
	}
}
