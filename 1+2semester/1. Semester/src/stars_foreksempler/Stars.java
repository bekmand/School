package stars_foreksempler;

public class Stars {
	final int MAX_ROWS = 10;
	
	public void starPicture(){
		for(int row = 1; row <= MAX_ROWS; row++){
			for (int star = 1; star <= row; star++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	

}
