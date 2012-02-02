package model_BarnArray;

public class AfprøvModel {

	
	public static void main(String[] args) {

		
		double[] weight1 = {4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9, 35.1,37.3};
		
		Barn b1 = new Barn("Emma", 1,false, weight1); // pige på 1 år
		Barn b2 = new Barn("Oliver",3,true, weight1);  // dreng på 3 år
		
		Institution i1 = new Institution("Lillevang", "Åbyvej 125");
		
		i1.addBarn(b1);
		i1.addBarn(b2);
		

		System.out.println(b1.getNavn() + " er " + b1.getAlder() + " år" );
		System.out.println(b2.getNavn() + " er " + b2.getAlder() + " år" );
		System.out.println(b1.weight(b1.getAlder()));
		System.out.println(b2.weight(b2.getAlder()));
		System.out.println("Største vægt på for: " + b1.getNavn() + " med : " + b1.weightComparison() + " kg");
		System.out.println("Gennemsnit alder for børne på " + i1.getNavn() + " : " + i1.gennemsnitAlder() + " år");
		System.out.println("Antal piger: " + i1.antalPiger());
		System.out.println("Antal Drenge: " + i1.antalDrenge());
		
		

	}

}
