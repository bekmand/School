
package forsikring;


public class BilForsikring {
	private static double grundPr�mie;
	
	public static double getGrundPr�mie(){
		return grundPr�mie;
	}
	
	public static  void setGrundp�mie(double grundPr){
		if (grundPr <= 0) throw new RuntimeException("grundPr skal v�re positiv");
		grundPr�mie = grundPr;
	}
	
	public static double beregnPr�mie(int alder, boolean isKvinde, int skadeFrie�r){
		double pr�mie = grundPr�mie;
		if (pr�mie == 0)
			throw new RuntimeException("GrundPr�mie har ikke f�et en v�rdi");
		if (alder < 18)
			throw new RuntimeException("Du er for ung til at tegne en forsikring");
		if (alder-skadeFrie�r < 18)
			throw new RuntimeException("Du kan ikke have k�rt skadefri s�l�nge");
		if (skadeFrie�r < 0)
			throw new RuntimeException("Antal skade frie �r skal v�re positiv");
		
		if (alder <= 25)
			pr�mie = pr�mie*1.25;
		
		if (isKvinde) pr�mie = pr�mie *0.95;
		
		if (skadeFrie�r < 3);
		else if (skadeFrie�r < 6)
			pr�mie = pr�mie *0.85;
		else if (skadeFrie�r < 9)
			pr�mie = pr�mie * 0.75;
		else pr�mie = pr�mie * 0.65;
		return pr�mie;
		
	}
	
	public static void main(String[] args) {
		setGrundp�mie(100);
		System.out.println(beregnPr�mie(30, false, 2));
	}

}
