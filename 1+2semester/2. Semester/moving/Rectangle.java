package moving;

public class Rectangle implements Moveable, Sizeable {

	private int x; // x,y angiver hvor i kkordinatsystemet rektanglen er
					// placeret
	private int y;
	private int b; // bredden af rektanglet
	private int h; // højden af rektanglet

	public Rectangle(int x, int y, int b, int h) {
		this.x = x;
		this.y = y;
		this.b = b;
		this.h = h;
	}

	/**
	 * Flytter rektanglet relativt til dets position
	 */
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;

	}

	@Override
	public void grow(int dx) {
		this.x *= dx;
		this.y *= dx;

	}

	@Override
	public int getWidth() {
		return this.x;
		}

	@Override
	public int getHeight() {
		return this.y;
	}

}
