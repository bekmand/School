package adapter;

public class vareTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiritus sp = new Spiritus(100, "buttweiser");

		ElVare v1 = new ElVare(100, "Stikd�se");
		FoedeVare v2 = new FoedeVare(20, "Bacon");
		SpiritusAdapter v3 = new SpiritusAdapter(sp ,100, "buttweiser");
		
		System.out.println(v1.getNavn() + "'ens moms er : " + v1.beregnMoms());
		System.out.println(v2.getNavn() + "'ens moms er : " + v2.beregnMoms());
		System.out.println(v3.getNavn() + "'ens moms er : " + v3.beregnMoms());
	}

}