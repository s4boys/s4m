package aufgabeZwei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mouse {
	Coordinate now;
	Coordinate last;
	boolean hasFoundCheese;
	Coordinate memories[];

	public Mouse() {
		this.hasFoundCheese = false;
		this.now = new Coordinate(0, 0);
		this.memories = new Coordinate[5 * 17];
		for (int i = 0; i < memories.length; i++) {
			memories[i] = new Coordinate();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Mouse mickey = new Mouse();
		while (!mickey.hasFoundCheese) {
			mickey.search();
			for (char[] a : Maze.maze) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println();
			Thread.sleep(250);

		}
	}

	public void checkForCheese() {
		if (Maze.maze[now.x][now.y] == 'o') {
			this.hasFoundCheese = true;
		}
	}

	// Prioritäten: 1. Unbesucht 2. rechts 3. unten 4. oben 5. links
	public void search() {
		List<Coordinate> possibleDirections = new ArrayList<>();
		if (now.y < 16) {
			possibleDirections.add(new Coordinate(now.x, now.y + 1, this.memories[(now.x * 17) + now.y + 1].visits)); // rechts
		}
		if (now.x < 4) {
			possibleDirections.add(new Coordinate(now.x + 1, now.y, this.memories[((now.x + 1) * 17) + now.y].visits)); // runter
		}
		if (now.y > 0) {
			possibleDirections.add(new Coordinate(now.x, now.y - 1, this.memories[(now.x * 17) + now.y - 1].visits)); // links
		}
		if (now.x > 0) {
			possibleDirections.add(new Coordinate(now.x - 1, now.y, this.memories[((now.x - 1) * 17) + now.y].visits)); // oben
		}

		// suche am wenigsten besuchte Richtung
		int newDirection = Integer.MAX_VALUE;
		Coordinate reallyNewDir = new Coordinate(0,0,0);
		for (Coordinate c : possibleDirections) {
			if (Maze.isFieldAccessible(c)) {
				if (c.visits < newDirection) {
					newDirection = c.visits;
					reallyNewDir = c;
				}
			}
		}
		this.last = this.now;
		this.now = reallyNewDir;
		this.checkForCheese();
		Maze.maze[now.x][now.y] = 'M';
		Maze.maze[last.x][last.y] = '_';
		this.memories[now.x*17+now.y].visits++;

		// gehe in eine der besten Richtungen, Priorität : rechts, runter, hoch, links
//		for (Coordinate c : possibleDirections) {
//			if (c.visits == newDirection) {
//				this.last = this.now;
//				this.now = c;
//				this.checkForCheese();
//				Maze.maze[now.x][now.y] = 'M';
//				Maze.maze[last.x][last.y] = '_';
//				break;
//			}
//		}

	}
}
