package aflOpgEfterAar;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Faelles f = new Faelles();
		MyThread t1 = new MyThread("Tråd 1", f);
		MyThread2 t2 = new MyThread2("Tråd 2", f);
		
		t1.start();
		t2.start();

	}

}
