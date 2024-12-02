import java.util.*;

public class UnweightedGraph<V> {
    private List<V> vertices;      // List of vertices
    private List<Edge> edges;      // List of edges
    private Map<V, List<V>> adjacencyList;  // Adjacency list for graph

    public UnweightedGraph(List<V> vertices, int[][] edges) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
        this.adjacencyList = new HashMap<>();
        
        for (V vertex : vertices) {
            adjacencyList.put(vertex, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            this.edges.add(new Edge(u, v));
            adjacencyList.get(vertices.get(u)).add(vertices.get(v));
            adjacencyList.get(vertices.get(v)).add(vertices.get(u));  // Assuming undirected graph
        }
    }

    // BFS Method returns SearchTree
    public SearchTree bfs(int startIndex) {
        V startVertex = vertices.get(startIndex);
        Map<V, V> parentMap = new HashMap<>();
        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();
        parentMap.put(startVertex, null);
        visited.add(startVertex);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            V vertex = queue.poll();
            for (V neighbor : adjacencyList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, vertex);
                    queue.offer(neighbor);
                }
            }
        }
        return new SearchTree(startVertex, parentMap);
    }

    // Inner SearchTree class that holds search results
    public class SearchTree {
        private V root;
        private Map<V, V> parentMap;

        public SearchTree(V root, Map<V, V> parentMap) {
            this.root = root;
            this.parentMap = parentMap;
        }

        public void printPath(V target) {
            LinkedList<V> path = new LinkedList<>();
            V current = target;
            while (current != null) {
                path.addFirst(current);
                current = parentMap.get(current);
            }
            System.out.println("Path to " + target + ": " + path);
        }

        public void printTree() {
            for (V vertex : vertices) {
                V parent = parentMap.get(vertex);
                System.out.println(vertex + " (parent: " + (parent == null ? "null" : parent) + ")");
            }
        }
    }

    // Edge class for holding edge data
    public class Edge {
        int u, v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            return u == ((Edge)o).u && v == ((Edge)o).v;
        }
    }
}
