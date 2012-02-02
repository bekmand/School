package Singleton;

public abstract class testCounter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		counter.getInstance().count();
		System.out.println(counter.getInstance().getValue());
		counter.getInstance().times2();
		System.out.println(counter.getInstance().getValue());
		counter.getInstance().zero();
		System.out.println(counter.getInstance().getValue());

	}

}
