package adjazenz;

import java.io.File;
 
public class Main {

	public static void main(String[] args) {
			Graph g = new Graph(new File("data.txt"));
			System.out.println("Eulergraph: " + g.isEulerGraph());
			System.out.println("Grad von A: " + g.getGrad("A"));
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
