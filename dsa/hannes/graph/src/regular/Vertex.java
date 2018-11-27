package regular;

public class Vertex {
	static int counter=0;
	private int id;
	private String name;
	private boolean visited;
	
	public Vertex(String name) {
		this.id = ++counter;
		this.name = name;
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
	
	
}
