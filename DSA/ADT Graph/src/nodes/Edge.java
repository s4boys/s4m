package nodes;

public class Edge {

	Vertex v0, v1;
	double weight = 0.0;
	
	public Edge(Vertex v0, Vertex v1, double weight) {
		this.v0 = v0;
		this.v1 = v1;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "\n" + v0.getId() + " " + v1.getId() + " " + weight;
	}
}
