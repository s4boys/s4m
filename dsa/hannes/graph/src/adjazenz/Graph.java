package adjazenz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

//    ArrayList<Vertex> knoten;
    int size;

    public Graph(File data) {
        ArrayList<String> lines = new ArrayList<>();
//        this.knoten = new ArrayList<>();
        this.knoten = new HashMap<>();
        String line;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(data));
            this.size = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String[] nodeNames = lines.remove(0).split(", ");
        for (String name : nodeNames) {
            knoten.put(new Vertex(name), new ArrayList<Edge>());
        }
        for (String s : lines) {
            String[] array = s.split(" ");
            Vertex source = getNodeFromId(Integer.parseInt(array[0]));
            Vertex destination = getNodeFromId(Integer.parseInt(array[1]));
            Double d = Double.parseDouble(array[2]);
            knoten.get(source).add(new Edge(destination, d));
            knoten.get(destination).add(new Edge(source, d));
//            source.addNeighbour(new Edge(destination, d));
//            destination.addNeighbour(new Edge(source,d));
        }
    }

    public int getGrad(String knotenname) {
        return knoten.get(getNodeFromName(knotenname)).size();
    }

    boolean isEulerGraph() {
        for (Vertex v : knoten.keySet()) {
            if (getGrad(v.getName()) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public void clearPath() {
        for (Vertex v : knoten.keySet()) {
            v.setVisited(false);
        }
    }

    public void tiefensuche(String name) {
        Vertex currentVertex = getNodeFromName(name);
        currentVertex.setVisited(true);
        System.out.print(name + " ");
        for (Edge e : knoten.get(currentVertex)) {
            if (!e.getDestination().isVisited()) {
                tiefensuche(e.getDestination().getName());
            }
        }
    }

    public void breitensuche(String name) {
        Vertex currentVertex = getNodeFromName(name);
        Queue<Vertex> q = new LinkedList<>();
        q.add(currentVertex);
        while (!q.isEmpty()) {
            Vertex v = q.remove();
            v.setVisited(true);
            System.out.print(v.getName() + " ");
            for (Edge e : knoten.get(v)) {
                if (!e.getDestination().isVisited() && !q.contains(e.getDestination())) {
                    q.add(e.getDestination());
                }
            }
        }
    }

    Vertex getNodeFromId(int id) throws IllegalVertexException {
        for (Vertex v : knoten.keySet()) {
            if (v.getId() == id) {
                return v;
            }
        }
        throw new IllegalVertexException();
    }

    Vertex getNodeFromName(String name) throws IllegalVertexException {
        for (Vertex v : knoten.keySet()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        throw new IllegalVertexException();
    }

    void shortestPath(Vertex start, Vertex destination) {
        Set<Vertex> knownNodes = new HashSet<>();
        Set<Vertex> remainingNodes = new HashSet<>();
        double[] distances = new double[this.getSize()];
        for (Vertex v : knoten.keySet()) {
            distances[v.getId() - 1] = Double.MAX_VALUE;
        }
        distances[start.getId() - 1] = 0;
        for (Edge e : knoten.get(start)) {
            distances[e.getDestination().getId() - 1] = e.getDistance();
            remainingNodes.add(e.getDestination());
        }
        while (!remainingNodes.isEmpty() && !knownNodes.contains(destination)) {
            Vertex nextNode = getClosestV(remainingNodes, distances);
            System.out.println(nextNode.getName());
            knownNodes.add(nextNode);
            remainingNodes.remove(nextNode);
            for(Edge e : knoten.get(nextNode)) {
                int nextId = e.getDestination().getId() - 1;
                double nextWeight = distances[nextNode.getId() - 1] + e.distance;
                if (distances[nextId] == Double.MAX_VALUE) {
                    remainingNodes.add(e.getDestination());
                    distances[nextId] = nextWeight;
                } else {
                    if (distances[nextId] >= nextWeight) {
                        distances[nextId] = nextWeight;
                    }
                }
            }
        }
        System.out.println("Shortest path from " + start.getName() + " to " + destination.getName() + " is " + distances[destination.getId() - 1]);
    }

    public int getSize() {
        return size;
    }

    public Vertex getClosestV(Set<Vertex> remainingNodes, double[] distances) {
		Vertex min = remainingNodes.stream().findFirst().get();
		for (Vertex v : remainingNodes) {
		    if(distances[v.getId()-1] < distances[min.getId()-1]) {
		        min = v;
		    }
		}
		return min;
	}

    @Override
    public String toString() {
        String s = "";
        for (Vertex v : knoten.keySet()) {
            s += "Neighbours of " + v.getId() + ": ";
            for (Edge e : knoten.get(v)) {
                s += e.getDestination().getId() + "(d=" + e.getDistance() + "), ";
            }
            s += "\n";
        }
        return size + "\n" + knoten + "\n" + s;
    }

}
