package adjazenz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph {

	HashMap<Vertex, ArrayList<Vertex>> knoten;
	int size;
	
	public Graph(HashMap<Vertex, ArrayList<Vertex>> knoten, int size) {
		this.knoten = knoten;
		this.size = size;
	}

	public int getGrad(String knotenname) {
	   Vertex v = getNodeFromName(knotenname);
	   ArrayList<Vertex> list = knoten.get(v);
	   return list.size();
	}
	
	boolean isEulerGraph() {
		for(Vertex v : knoten.keySet()) {
			if (getGrad(v.getName())%2 != 0) {
				return false;
			}
		}
		return true;
	}
	
	public void tiefensuche(String nameStartknoten) {
		Vertex vert = getNodeFromName(nameStartknoten);
		vert.setVisited(true);
		System.out.print(vert + " ");
		ArrayList<Vertex> list = knoten.get(vert);
		for (Vertex v : list) {
			if (!v.isVisited()) {
				tiefensuche(v.getName());
			} 
		}
	}
	
	public void breitensuche(String nameStartknoten) {
		Vertex vert = getNodeFromName(nameStartknoten);
		Queue<Vertex> q = new LinkedList<>();
	    q.add(vert);
		while(!q.isEmpty()) {
			Vertex node = q.remove();
			System.out.print(node + " ");
			node.setVisited(true);
			ArrayList<Vertex> list = knoten.get(node);
			for (Vertex v : list) {
				if(!v.isVisited() && !q.contains(v)) {
					q.add(v);
				}
			}
		}
	}
	
	Vertex getNodeFromName(String name) {
		for(Map.Entry<Vertex, ArrayList<Vertex>> e : knoten.entrySet()) {
			Vertex v = (Vertex)	e.getKey();
			if(v.getName().equals(name)) {
				return v;
			} 
		}
		throw new IllegalVertexException();
	}
	
	@Override
	public String toString() {
		return size + "\n" + knoten + "\n" ;
	}
	

	
	
}
