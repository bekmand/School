package moving;

public class TestKlassen {

	/**
	 * @param args
	 */
	
	public static void printPos (Moveable m) {
		System.out.println("Position:  (" + m.getX() + " , " + m.getY() + ")" );
	
	}

	public static void main(String[] args) {
		Circle c = new Circle(10,20,50);
		printPos(c);
		c.move(5, 7);
		printPos(c);
		c.grow(2);
		printPos(c);
		
		System.out.println("----------------------");
		
		Rectangle r = new Rectangle (25,25,40,20);
		printPos(r);
		r.move(10, 20); 
		printPos(r);
		
		System.out.println();
		
		System.out.println();
	}

}
