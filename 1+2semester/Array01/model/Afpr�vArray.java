package model;

public class AfprøvArray {
	public static void main(String[] args) {
		
		ArrayMetoder am1 = new ArrayMetoder();
		
		int[] tal1 = {4, 5, 6, 7 , 3};
		double[] tal2 = {4.6, 3.7, 9.2, 11.2, 3.4};
		int[] tal3 = {2,3,1,2,4};
		
		System.out.println("Tal1: " + am1.sum(tal1));
		System.out.println("Tal2: " + am1.dSum(tal2));
		
		int[] temp = am1.danSum(tal1, tal3);
		for(int i = 0; i < temp.length; i++){
			if(i == temp.length -1){
				System.out.println(temp[i]);
			}
			else{
			System.out.print(temp[i] + ", ");
			}
		}
		System.out.println("Har Array'et et ulige tal? " + am1.harUlige(tal1));
		
	}

}
