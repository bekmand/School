package bil2;

public class BilUdlejning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Udlejning Ud1 = new Udlejning(12,"01-04",2);
		Udlejning Ud2 = new Udlejning(13,"05-04",1);
		Udlejning Ud3 = new Udlejning(14,"04-04",3);
		Udlejning Ud4 = new Udlejning(15,"03-04",4);
		Udlejning Ud5 = new Udlejning(16,"02-04",5);
		
		Bil b1 = new Bil("01-04",1990);
		Bil b2 = new Bil("01-04",1990);
		
		Ud1.addBil(b1);
		Ud2.addBil(b2);
		Ud3.addBil(b1);
		Ud4.addBil(b2);
		Ud5.addBil(b1);
		
		/*
		b1.addUdlejning(Ud1);
		b1.addUdlejning(Ud3);
		b1.addUdlejning(Ud5);
		b2.addUdlejning(Ud2);
		b2.addUdlejning(Ud4);
		*/
	}

}