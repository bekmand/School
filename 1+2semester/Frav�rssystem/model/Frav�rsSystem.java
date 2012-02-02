package model;

public class FraværsSystem {

	public void udskrivFravær(int[][] fravær) {
		for (int row = 0; row < fravær.length; row++) {
			for (int col = 0; col < fravær[row].length; col++) {
				System.out.print(fravær[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int samletFravær(int[][] fravær, int elevNr) {
		int i = 0;
		int count = 0;
		while(i < fravær[elevNr-1].length){
			count += fravær[elevNr-1][i];
			i++;
		}
		return count;
	}

	public int ingenFravær(int[][] fravær) {
		int sum = 0;
		int count = 0;
		int check = 0;
		
		while(count < fravær.length){
			if (check == samletFravær(fravær, count+1)){
				sum = count;
			}
			count++;
		}
		
		return sum+1;
	}

	public int mindstFravær(int[][] fravær) {
		int sum = 0;
		int count = 0;
		int elevNr = samletFravær(fravær, 0+1);
		
		while(count < fravær.length){
			if (elevNr > samletFravær(fravær, count+1)){
				elevNr = samletFravær(fravær, count+1);
				sum = count;
			}
			count++;
		}
		
		return sum+1;
	}

	public int mestFravær(int[][] fravær) {
		int sum = 0;
		int count = 0;
		int elevNr = samletFravær(fravær, 0+1);
		
		while(count < fravær.length){
			if (elevNr < samletFravær(fravær, count+1)){
				elevNr = samletFravær(fravær, count+1);
				sum = count;
			}
			count++;
		}
		
		return sum+1;
	}

	public double gennemsnit(int[][] fravær, int elevNr) {
		double sum = 0;
		for (int col = 0; col < fravær[elevNr].length; col++) {
			sum += fravær[elevNr][col];
		}
		return sum/12.0;
	}

	public void nulstil(int[][] fravær, int elevNr) {
		for (int i = 0; i < fravær[elevNr].length; i++) {
			fravær[elevNr][i] = 0;
		}
		System.out.println();
		udskrivFravær(fravær);
		
	}
}
