package metoder;

public class AfproevMetoder {
	public static void main(String[] args) {
		
		Metoder m1 = new Metoder();
		String[] navne = {"Martin", "Stephan", "Anders", "Niels", "Kristian", "Thomas", "Dennis"};
		Integer[] tal = {4,3,6,4,1,3,6,4,8,6,3};
		
		// TODO Auto-generated method stub
//		System.out.println(m1.findStorStreng(navne));
//		System.out.println(m1.findStorInteger(tal));
//		System.out.println(m1.findStorComparable(tal));
//		System.out.println(m1.findStorComparable(navne));
		System.out.println(m1.findComparableLin(navne, "Niels"));
	}

}
