package adjazenz;

public class Edge {

	Vertex v0;
	double weight = 0.0;
	
	public Edge(Vertex v0, double weight) {
		this.v0 = v0;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "\n" + v0.getId() + " " + weight;
	}
}
