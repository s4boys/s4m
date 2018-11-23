package adjazenzHannes;

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
			System.out.print("Breitensuche: ");
			g.breitensuche("A");		
			System.out.println();
			g.clearPath();
			System.out.print("Tiefensuche: ");
			g.tiefensuche("A");
			System.out.println();
			g.clearPath();

		
	}
}
