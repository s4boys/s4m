package aufgabeZwei;

public class Coordinate {
	int x;
	int y;
	int visits;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		this.visits = 0;
	}
	public Coordinate() {
		this(0,0);
	}
	public Coordinate(int x, int y, int v) {
		this.x = x;
		this.y = y;
		this.visits = v;
	}

}
