
package model;



public class AfprøvFraværsSystem {

	public static void main(String[] args) {
		int[][] fravær10S = {{2,0,0,0,3,1,0,2,0,0,0,0},
				   		  {0,0,0,0,0,0,0,0,0,0,0,0},
				   		  {2,0,0,0,3,1,0,2,0,0,0,0},
				   		  {1,2,1,2,1,2,0,2,0,10,1,0},
				          {5,0,0,0,0,0,0,9,0,0,0,0}};
				              
		FraværsSystem karakterSystem = new FraværsSystem();
//		karakterSystem.udskrivFravær(fravær10S);
//		karakterSystem.samletFravær(fravær10S, 3);
		System.out.println("Mindst fravær " + karakterSystem.mindstFravær(fravær10S));
		System.out.println("Mest fravær " + karakterSystem.mestFravær(fravær10S));
		System.out.println("Gennemsnits fravær " + karakterSystem.gennemsnit(fravær10S, 3));
//		karakterSystem.nulstil(fravær10S, 0);
		System.out.println("Ingen fravær " + karakterSystem.ingenFravær(fravær10S));
	}
}
