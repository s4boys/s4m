package adjazenz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("data.txt")));
			int size = Integer.parseInt(br.readLine());
			String[] names = br.readLine().split(", ");
			HashMap<Vertex, ArrayList<Vertex>> knoten = new HashMap<>();
//			ArrayList<Vertex> knoten = new ArrayList<>();
			for (String name : names) {
				knoten.put(new Vertex(name), new ArrayList<Vertex>());
//				knoten.get(name).add(new Vertex(name));
			}
//			ArrayList<Edge> kanten= new ArrayList<>();
			String line;
			
			Set<Vertex> keyset = knoten.keySet();
			for ( Vertex v : keyset) {
				int id = v.getId();
				String[] array = line.split(" ");
				if (Integer.parseInt(array[0]) == id) {
					knoten.get(v).add()
				}
			}
			
			
			while((line = br.readLine()) != null) {
				String[] array = line.split(" ");
				getVertex(getVertex(array[0], knoten), knoten)
				knoten.get(new Vertex(array[0]).add(new Vertex(array[1])));
				double[] values = Arrays.asList(array).stream().mapToDouble(Double::parseDouble).toArray();
				
//				kanten.add(new Edge(getVertex((int) values[0], knoten), getVertex((int) values[1], knoten), values[2]));
			}
			
			
			
			
			Graph g = new Graph(knoten, kanten, size);
			g.tiefensuche("A");
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
}
