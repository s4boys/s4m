package osm;



public class Vertex {
	private static int counter=1;
	
	private int id;
	private String name;
	private boolean visited;
	private double lat;
	private double lon;
//	private ArrayList<Edge> neighbours;
	
	public Vertex(String name, double lat, double lon) {
		this.id = counter++;
		this.name = name;
		this.visited= false;
		this.lat = lat;
		this.lon = lon;
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

    public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

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
