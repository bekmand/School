package aflOpgEfterAar;

public class MyThread extends Thread{
	private String navn;
	private Faelles faelles;
	
	public MyThread(String navn, Faelles faelles){
		super();
		this.navn = navn;
		this.faelles = faelles;
	}
	
	public void run(){
		for(int j = 0; j<100; j++){
			faelles.P0();
			faelles.TagerRandomTid(50);
		}
		System.out.println(faelles.getGlobal());
	}
}
	

