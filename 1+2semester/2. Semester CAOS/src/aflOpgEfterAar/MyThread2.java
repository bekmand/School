package aflOpgEfterAar;

public class MyThread2 extends Thread{
	private String navn;
	private Faelles faelles;
	
	public MyThread2(String navn, Faelles faelles){
		super();
		this.navn = navn;
		this.faelles = faelles;
	}
	
	public void run(){
		for(int j = 0; j<100; j++){
			faelles.P1();
			faelles.TagerRandomTid(50);
		}
		System.out.println(faelles.getGlobal());
	}
}
	

