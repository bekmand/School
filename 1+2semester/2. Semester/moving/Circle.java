package moving;

public class Circle implements Moveable, Sizeable {

	private int x;
	private int y;
	private int r;

	public Circle(int x, int y, int r) {

		this.x = x;
		this.y = y;
		this.r = r;
	}

	@Override
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;

	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void grow(int dx) {
		this.r *= dx;
	}

	@Override
	public int getWidth() {
		return this.r * 2;
	}

	@Override
	public int getHeight() {
		return this.r * 2;
	}

}
