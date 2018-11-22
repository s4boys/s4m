package adjazenz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
			Graph g = new Graph(new File("data.txt"));
			System.out.println(g);
			
			System.out.println("Tiefensuche:");
			g.tiefensuche("A");
			g.clearPath();
			System.out.println("Breitensuche:");
			g.breitensuche("A");		
			g.clearPath();
		
	}
}
