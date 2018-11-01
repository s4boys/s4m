package aufgabeZwei;

public class Maze {
	
		//	{ '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_' }
		//	{ '_', 'X', '_', '_', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '_' }
		//	{ '_', 'X', '_', '_', 'X', '_', '_', '_', '_', 'X', 'o', '_', '_', 'X', '_', '_', '_' }
		//	{ '_', 'X', 'X', 'X', 'X', '_', 'X', 'X', '_', 'X', 'X', '_', 'X', 'X', 'X', 'X', '_' }
		//	{ '_', '_', '_', '_', '_', '_', '_', 'X', '_', '_', '_', '_', '_', '_', '_', '_', '_' } startpunkt am anfang
	static char maze[][] = { 
			{ '_', '_', '_', '_', '_', '_', '_', 'X', '_', '_', '_', '_', '_', '_', '_', '_', '_' },
			{ '_', 'X', 'X', 'X', 'X', '_', 'X', 'X', '_', 'X', 'X', '_', 'X', 'X', 'X', 'X', '_' },
			{ '_', 'X', '_', '_', 'X', '_', '_', '_', '_', 'X', 'o', '_', '_', 'X', '_', '_', '_' },
			{ '_', 'X', '_', '_', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '_' },
			{ '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_' } };

	public static boolean isFieldAccessible(Coordinate c) {
		if (c.x >= maze.length || c.y >= maze[1].length) {
			return false;
		}
		if (maze[c.x][c.y] == 'X') {
			return false;
		}
		return true;
	}

	public static boolean isFieldCheese(Coordinate c) {
		if (maze[c.x][c.y] == 'o') {
			return true;
		}
		return false;
	}

}
