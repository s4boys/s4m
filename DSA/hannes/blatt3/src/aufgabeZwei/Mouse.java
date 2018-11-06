package aufgabeZwei;

import aufgabeEinsA.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mouse {
	Coordinate now;
	Coordinate last;
	Coordinate secondLast;
	boolean hasFoundCheese;
	Stack path;
	ArrayList<Coordinate> visited;

	public Mouse(int x, int y) {
		this.hasFoundCheese = false;
		this.now = new Coordinate(x,y);
		this.last = new Coordinate(x,y);
		this.secondLast = new Coordinate(x,y);
		this.path = new Stack();
		this.visited = new ArrayList<>();
		Maze.maze[now.x][now.y] = 'M';
	}

	public static void main(String[] args) throws InterruptedException {
		Mouse mickey = new Mouse(0,0);
		mickey.path.push(mickey.now);
		while (!mickey.hasFoundCheese && !mickey.path.isEmpty()) {			

			mickey.search();
			for (char[] a : Maze.maze) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println(mickey.path.toString());
			Thread.sleep(250);

		}
	}



	public void search() {

		Coordinate right = new Coordinate(now.x, now.y + 1);
		Coordinate down = new Coordinate(now.x + 1, now.y);
		Coordinate up = new Coordinate(now.x - 1, now.y);
		Coordinate left = new Coordinate(now.x, now.y - 1);			
		
		if (now.y < 16 && Maze.isFieldAccessible(right)  && unvisited(right)) {
			now = right;
		} else if (now.x < 16 && Maze.isFieldAccessible(down)  && unvisited(down)) {
			now = down;
		} else if (now.x > 0 && Maze.isFieldAccessible(up)  && unvisited(up)) {
			now = up;
		} else if (now.y > 0 && Maze.isFieldAccessible(left)  && unvisited(left)) {
			now = left;
		} else {
			path.pop();			
			now = (Coordinate)path.pop();
			
		}
		visited.add(secondLast);
		last = secondLast;
		secondLast = now;
		
		checkCheeseFound();
		
		Maze.maze[now.x][now.y] = 'M';
		Maze.maze[last.x][last.y] = '_';
		path.push(now);
	}

	public void checkCheeseFound() {
		if (Maze.maze[now.x][now.y] == 'K') {
			this.hasFoundCheese = true;
			System.out.println("gefunden");
		}
	}

	public boolean unvisited(Coordinate input) {
		for (Coordinate c : visited) {
			if (c.x == input.x && c.y == input.y) {
				return false;
			}
		}
		return true;
	}
}
