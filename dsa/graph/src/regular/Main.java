package regular;

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
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("data.txt")));
			int size = Integer.parseInt(br.readLine());
			String[] names = br.readLine().split(", ");
			ArrayList<Vertex> knoten = new ArrayList<>();
			for (String name : names) {
				knoten.add(new Vertex(name));
			}
			ArrayList<Edge> kanten= new ArrayList<>();
			String line;
			while((line = br.readLine()) != null) {
				String[] array = line.split(" ");
				double[] values = Arrays.asList(array).stream().mapToDouble(Double::parseDouble).toArray();
				kanten.add(new Edge(getVertex((int) values[0], knoten), getVertex((int) values[1], knoten), values[2]));
			}
			Graph g = new Graph(knoten, kanten, size);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Vertex getVertex(int id, ArrayList<Vertex> knoten) {
		ListIterator<Vertex> lit = knoten.listIterator();
		while(lit.hasNext()) {
			Vertex v = lit.next();
			if(v.getId() == id) {
				return v;
			} 
		}
		throw new IllegalVertexException();
	}
	
	public static void clearVertices(ArrayList<Vertex> knoten) {
		for (Vertex v : knoten) {
			v.setVisited(false);
		}
	}
}
