import java.util.ArrayList;
import java.util.List;

public abstract class Graph<V> {
    protected List<V> vertices = new ArrayList<>();
    protected List<List<Edge>> neighbors = new ArrayList<>();

    protected Graph() {}

    protected Graph(List<V> vertices, int[][] edges) {
        for (V vertex : vertices) {
            addVertex(vertex);
        }

        createAdjacencyLists(edges, vertices.size());
    }

    protected void createAdjacencyLists(int[][] edges, int numberOfVertices) {
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
    }

    public boolean addVertex(V vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            neighbors.add(new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(int u, int v) {
        if (u < 0 || u >= vertices.size() || v < 0 || v >= vertices.size()) {
            throw new IllegalArgumentException("No such index: " + u + " or " + v);
        }
        neighbors.get(u).add(new Edge(u, v));
        neighbors.get(v).add(new Edge(v, u));
        return true;
    }

    public List<V> getVertices() {
        return vertices;
    }

    public List<Integer> getNeighbors(int index) {
        List<Integer> result = new ArrayList<>();
        for (Edge e : neighbors.get(index)) {
            result.add(e.v);
        }
        return result;
    }
}
