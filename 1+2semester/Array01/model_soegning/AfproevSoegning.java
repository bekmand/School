package model_soegning;

public class AfproevSoegning {
	public static void main(String[] args) {
		
		Soegning s1 = new Soegning();
		
		int[] tal1 = {2,2,6,4,4};
		int[] tal2 = {7, 56, 34, 3, 7, 14, 13, 4};
		int[] tal3 = {7, 9, 13, 3, 9, 7};
		
		System.out.println(s1.soeg(tal1));
		System.out.println(s1.soeg1(tal2));
		System.out.println(s1.soeg2(tal3));

	}

}
