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
			HashMap<Vertex, ArrayList<Edge>> knoten = new HashMap<>();
			for (String name : names) {
				knoten.put(new Vertex(name), new ArrayList<Edge>());
			}
			String line;
			while((line = br.readLine()) != null) {
				String[] array = line.split(" ");
				Edge alpha = new Edge(getVertex(Integer.parseInt(array[0]), knoten), Integer.parseInt(array[2]));
				Edge beta = new Edge(getVertex(Integer.parseInt(array[1]), knoten), Integer.parseInt(array[2]));
				knoten.get(alpha.v0).add(beta);
				knoten.get(beta.v0).add(alpha);
			}
			Graph g = new Graph(knoten, size);
//			System.out.println("Eulergraph? "  + g.isEulerGraph());
//			System.out.println("Grad von A: " + g.getGrad("A"));
//			System.out.print("Breitensuche: ");
//			g.breitensuche("A");
//			System.out.println();
//			clearVertices(knoten);
//			System.out.print("Tiefensuche: ");
//			g.tiefensuche("A");
//			System.out.println("\nGraph:");
//			System.out.println(g);
			g.shortestPath(g, g.getNodeFromName("A"), g.getNodeFromName("E"));
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
	public static Vertex getVertex(int id, HashMap<Vertex, ArrayList<Edge>> knoten) {
		for(Map.Entry<Vertex, ArrayList<Edge>> e : knoten.entrySet()) {
			Vertex v = (Vertex)	e.getKey();
			if(v.getId() == id) {
				return v;
			} 
		}
		throw new IllegalVertexException();
	}
	
	//setzt alle auf visited = false
	public static void clearVertices(HashMap<Vertex, ArrayList<Edge>> knoten) {
		for (Map.Entry<Vertex, ArrayList<Edge>> e : knoten.entrySet()) {
			Vertex v = (Vertex) e.getKey();
			v.setVisited(false);
		}		
	}
}
