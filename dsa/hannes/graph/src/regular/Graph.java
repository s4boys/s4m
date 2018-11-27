package regular;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Graph {

	ArrayList<Vertex> knoten;
	ArrayList<Edge> kanten;
	int size;
	
	public Graph(ArrayList<Vertex> knoten, ArrayList<Edge> kanten, int size) {
		this.knoten = knoten;
		this.kanten = kanten;
		this.size = size;
	}

	public int getGrad(String knotenname) {
	   int grad = 0;
	   ListIterator<Edge> lit = kanten.listIterator();
	   Edge e;
	   while(lit.hasNext()) {
		   e = lit.next();
		   if(e.v0.getName().equals(knotenname) || e.v1.getName().equals(knotenname)) {
			   grad++;
		   }
	   }
	   return grad;
	}
	
	boolean isEulerGraph() {
		for(Vertex v : knoten) {
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
		for (Edge e : kanten) {
			if (e.v0 == vert && !e.v1.isVisited()) {
				tiefensuche(e.v1.getName());
			} else if (e.v1 == vert && !e.v0.isVisited()) {
				tiefensuche(e.v0.getName());
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
			for (Edge e : kanten) {
				if(e.v0 == node && !e.v1.isVisited() && !q.contains(e.v1)) {
					q.add(e.v1);
				} else if (e.v1 == node && !e.v0.isVisited() && !q.contains(e.v0)) {
					q.add(e.v0);
				}
			}
		}
	}
	
	Vertex getNodeFromName(String name) {
		for (Vertex v : knoten) {
			if (v.getName().equals(name)) {
				return v;
			}
		}
		throw new IllegalVertexException();
	}
	
	@Override
	public String toString() {
		return size + "\n" + knoten + "\n" + kanten;
	}
	

	
	
}
