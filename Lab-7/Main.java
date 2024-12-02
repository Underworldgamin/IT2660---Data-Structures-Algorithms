import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] vertices = {
            "Liberal Arts", "Student Services", "Health Careers & Sciences",
            "Health Technologies Center", "Recreation Center",
            "Technology Learning Center", "Business & Technology", "Theatre"
        };

        int[][] edges = {
            {0, 1}, {1, 2}, {1, 5}, {2, 3}, {2, 4}, {3, 4}, {5, 6}, {6, 7}, {1, 7}
        };

        UnweightedGraph<String> graph = new UnweightedGraph<>(Arrays.asList(vertices), edges);

        var bfs = graph.bfs(6); // Start from Business & Technology
        bfs.printPath("Health Technologies Center"); // Path to Health Technologies Center
        bfs.printPath("Student Services"); // Path to Student Services
        bfs.printPath("Recreation Center"); // Path to Recreation Center
        bfs.printTree(); // Print entire tree
    }
}
