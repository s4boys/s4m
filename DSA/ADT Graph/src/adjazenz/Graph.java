package adjazenz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

	HashMap<Vertex, ArrayList<Edge>> knoten;
	int size;
	
	public Graph(HashMap<Vertex, ArrayList<Edge>> knoten, int size) {
		this.knoten = knoten;
		this.size = size;
	}

	public int getGrad(String knotenname) {
	   Vertex v = getNodeFromName(knotenname);
	   ArrayList<Edge> list = knoten.get(v);
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
		ArrayList<Edge> list = knoten.get(vert);
		for (Edge v : list) {
			if (!v.v0.isVisited()) {
				tiefensuche(v.v0.getName());
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
			ArrayList<Edge> list = knoten.get(node);
			for (Edge v : list) {
				if(!v.v0.isVisited() && !q.contains(v.v0)) {
					q.add(v.v0);
				}
			}
		}
	}
	
	Vertex getNodeFromName(String name) {
		for(Map.Entry<Vertex, ArrayList<Edge>> e : knoten.entrySet()) {
			Vertex v = (Vertex)	e.getKey();
			if(v.getName().equals(name)) {
				return v;
			} 
		}
		throw new IllegalVertexException();
	}
	
	void shortestPath(Graph g, Vertex start, Vertex ziel) {
		Set<Vertex> M1 = new HashSet<>();
		Set<Vertex> M2 = new HashSet<>();
		double[] L = new double[11];
		for(Map.Entry<Vertex, ArrayList<Edge>> e : knoten.entrySet()) {
			Vertex v = (Vertex) e.getKey();
			L[v.getId()-1] = Integer.MAX_VALUE;
		}
		L[start.getId()-1] = 0;
		for (Edge e : knoten.get(start)) {
			 L[e.v0.getId()-1] = e.weight;
			 M2.add(e.v0);
		}
		while(M2 != null && !M1.contains(ziel)) {
			Vertex recentNode = getMin(M2, L);
			M1.add(recentNode);
			M2.remove(recentNode);
			for (Edge e : knoten.get(recentNode)) {
				int newId = e.v0.getId()-1;
				double newWeight = L[recentNode.getId()-1] + e.weight;
				if(L[newId] == Integer.MAX_VALUE) {
					M2.add(e.v0);
					L[newId] = newWeight;
				} else {
					if (L[newId] >= newWeight) {
						L[newId] = newWeight;
					}
				}
			}
			
		}
		System.out.println(Arrays.toString(L));
	}
	
	public Vertex getMin(Set<Vertex> M2, double[] zahlen) {
		Vertex min = M2.stream().findFirst().get();
		Iterator<Vertex> setIterator = M2.iterator();
        while(setIterator.hasNext()){
        	Vertex v = setIterator.next();
            if(zahlen[v.getId()-1] < zahlen[min.getId()-1]) {
            	min = v;
            }
        }
		return min;
	}
	
	@Override
	public String toString() {
		return size + "\n" + knoten + "\n" ;
	}
	

	
	
}
