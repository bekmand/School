package stringeksempel;

public class AfprøvStringMetoder {


	public static void main(String[] args) {
		StringEksempler se = new StringEksempler();
		System.out.println(se.countDigits("Margrethe Dybdahl 45, 8270 Højbjerg"));
		se.spacePositions("Margrethe Dybdahl 45, 8270 Højbjerg");
		System.out.println(se.insertSpace("Margrethe.Dybdahl.45, 8270.Højbjerg"));
	}
}
