package adjazenz;

import java.util.ArrayList;


public class Vertex {
	private static int counter=1;
	
	private int id;
	private String name;
	private boolean visited;
//	private ArrayList<Edge> neighbours;
	
	public Vertex(String name) {
		this.id = counter++;
		this.name = name;
		this.visited= false;
//		neighbours = new ArrayList<>();
	}
	
//	public void addNeighbour(Edge e) {
//	    if (!neighbours.contains(e)) {
//	        neighbours.add(e);
//	    }
//	    else {
//	        System.out.println("Knoten schon enthalten!");
//	    }
//	}

//	public ArrayList<Edge> getNeighbours() {
//        return neighbours;
//    }

    public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Vertex other = (Vertex) obj;
        return other.name.equals(this.name);
    }
    
	
}
