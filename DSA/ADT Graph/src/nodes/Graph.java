package nodes;

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
		   if(e.v0.name.equals(knotenname) || e.v1.name.equals(knotenname)) {
			   grad++;
		   }
	   }
	   return grad;
	}
	
	boolean isEulerGraph() {
		for(Vertex v : knoten) {
			if (getGrad(v.name)%2 != 0) {
				return false;
			}
		}
		return true;
	}
	
	public void tiefensuche(Vertex nameStartknoten) {
		nameStartknoten.setVisited(true);
		System.out.println(nameStartknoten);
		for (Edge e : kanten) {
			if (e.v0 == nameStartknoten && !e.v1.visited) {
				tiefensuche(e.v1);
			} else if (e.v1 == nameStartknoten && !e.v0.visited) {
				tiefensuche(e.v0);
			}
		}
	}
	
	public void breitensuche(Vertex nameStartknoten) {
		Queue<Vertex> q = new LinkedList<>();
	    q.add(nameStartknoten);
		while(!q.isEmpty()) {
			Vertex e = q.remove();
			System.out.println(e);
			e.visited = true;
			for (Edge e1 : kanten) {
				if(e1.v0 == e && !e1.v1.visited && !q.contains(e1.v1)) {
					q.add(e1.v1);
				} else if (e1.v1 == e && !e1.v0.visited && !q.contains(e1.v0)) {
					q.add(e1.v0);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return size + "\n" + knoten + "\n" + kanten;
	}
	

	
	
}
