package adjazenz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("data.txt")));
			int size = Integer.parseInt(br.readLine());
			String[] names = br.readLine().split(", ");
			HashMap<Vertex, ArrayList<Vertex>> knoten = new HashMap<>();
			for (String name : names) {
				knoten.put(new Vertex(name), new ArrayList<Vertex>());
			}
			String line;
			while((line = br.readLine()) != null) {
				String[] array = line.split(" ");
				Vertex alpha = getVertex(Integer.parseInt(array[0]), knoten);
				Vertex beta = getVertex(Integer.parseInt(array[1]), knoten);
				knoten.get(alpha).add(beta);
				knoten.get(beta).add(alpha);
			}
			Graph g = new Graph(knoten, size);
			System.out.println("Eulergraph? "  + g.isEulerGraph());
			System.out.println("Grad von A: " + g.getGrad("A"));
			System.out.print("Breitensuche: ");
			g.breitensuche("A");
			System.out.println();
			clearVertices(knoten);
			System.out.print("Tiefensuche: ");
			g.tiefensuche("A");
			System.out.println("\nGraph:");
			System.out.println(g);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//sucht id aus Knotenmap
	public static Vertex getVertex(int id, HashMap<Vertex, ArrayList<Vertex>> knoten) {
		for(Map.Entry<Vertex, ArrayList<Vertex>> e : knoten.entrySet()) {
			Vertex v = (Vertex)	e.getKey();
			if(v.getId() == id) {
				return v;
			} 
		}
		throw new IllegalVertexException();
	}
	
	//setzt alle auf visited = false
	public static void clearVertices(HashMap<Vertex, ArrayList<Vertex>> knoten) {
		for (Map.Entry<Vertex, ArrayList<Vertex>> e : knoten.entrySet()) {
			Vertex v = (Vertex) e.getKey();
			v.setVisited(false);
		}		
	}
}
