package moving;

public interface Moveable {

	/**
	 * Flytter objektet relativt til dets position
	 */
	public void move(int dx, int dy);

	/**
	 * Returnerer x-koordinaten for hvor objektet er placeret
	 */
	public int getX();

	/**
	 * Returnerer y-koordinaten for hvor objektet er placeret
	 */
	public int getY();
	
	public void setPosition(int x, int y);

}
