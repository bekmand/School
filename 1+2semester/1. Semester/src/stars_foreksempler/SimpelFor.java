package stars_foreksempler;

public class SimpelFor {
	public static void main(String[] args) {
		
		int i = 1;
		int sum = 0;
		while (i<=10){
			sum = sum + i;
			i++;
		}
		System.out.println("Summen beregnet med while " + sum);
		
//		int sum = 0;
//		for(int j = 1; j<=10; j++){
//			sum = sum +j;
//		}
//		System.out.println("Summen beregnet med while " + sum);
//
//		
//		for (int i=20; i>0; i--){
//			if (i%2==0)
//				System.out.println(i + " er lige");
//		}
		
//		int antal = 0;
//		for (int i = 1; i<=10; i++){
//			for (int j=1; j<=4; j++){
//				antal = antal + 1;
//			}
//		}
//		System.out.println("Antal er " + antal);
	}

}
