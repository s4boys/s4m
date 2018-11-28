package osm;

public class Edge {

    Vertex destination;
    double distance = 0.0;

    public Edge(Vertex de, double di) {
        this.destination = de;
        this.distance = di;
    }

    public Vertex getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return destination.getId() + " " + distance;
    }
}
