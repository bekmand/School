package stringeksempel;

public class Afpr�vStringMetoder {


	public static void main(String[] args) {
		StringEksempler se = new StringEksempler();
		System.out.println(se.countDigits("Margrethe Dybdahl 45, 8270 H�jbjerg"));
		se.spacePositions("Margrethe Dybdahl 45, 8270 H�jbjerg");
		System.out.println(se.insertSpace("Margrethe.Dybdahl.45, 8270.H�jbjerg"));
	}
}
