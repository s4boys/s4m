package aufgabeZwei;

public class Coordinate {
	int x;
	int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Coordinate() {
		this(0,0);
	}
	
	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
