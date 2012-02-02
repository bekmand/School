
package forsikring;


public class BilForsikring {
	private static double grundPræmie;
	
	public static double getGrundPræmie(){
		return grundPræmie;
	}
	
	public static  void setGrundpæmie(double grundPr){
		if (grundPr <= 0) throw new RuntimeException("grundPr skal være positiv");
		grundPræmie = grundPr;
	}
	
	public static double beregnPræmie(int alder, boolean isKvinde, int skadeFrieÅr){
		double præmie = grundPræmie;
		if (præmie == 0)
			throw new RuntimeException("GrundPræmie har ikke fået en værdi");
		if (alder < 18)
			throw new RuntimeException("Du er for ung til at tegne en forsikring");
		if (alder-skadeFrieÅr < 18)
			throw new RuntimeException("Du kan ikke have kørt skadefri sålænge");
		if (skadeFrieÅr < 0)
			throw new RuntimeException("Antal skade frie år skal være positiv");
		
		if (alder <= 25)
			præmie = præmie*1.25;
		
		if (isKvinde) præmie = præmie *0.95;
		
		if (skadeFrieÅr < 3);
		else if (skadeFrieÅr < 6)
			præmie = præmie *0.85;
		else if (skadeFrieÅr < 9)
			præmie = præmie * 0.75;
		else præmie = præmie * 0.65;
		return præmie;
		
	}
	
	public static void main(String[] args) {
		setGrundpæmie(100);
		System.out.println(beregnPræmie(30, false, 2));
	}

}
