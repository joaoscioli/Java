package findingCyclesGraph_in_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/// # GraphCycleDetection
/// Implementation of cycle detection in an **undirected graph** using **Depth-First Search (DFS)**.
///
/// ## Features
/// - Uses an adjacency list to represent the graph.
/// - Detects cycles in an **undirected graph**.
/// - Uses DFS with a **visited set** and **parent tracking**.
///
/// ## Complexity
/// - **Time Complexity:** O(V + E), where `V` is the number of vertices and `E` is the number of edges.
/// - **Space Complexity:** O(V), due to the recursion stack and visited set.
///
/// ## Example
/// ```
/// Input:
/// Edges: [(0,1), (0,2), (1,2), (2,0), (2,3), (3,3)]
///
/// Output:
/// The graph contains a cycle.
/// ```
public class GraphCycleDetection {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    /// Initializes a graph with `V` vertices.
    ///
    /// ## Parameters
    /// - `vertices`: The number of vertices in the graph.
    public GraphCycleDetection(int vertices) {
        V = vertices;
        adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    /// Adds an undirected edge between two vertices.
    ///
    /// ## Parameters
    /// - `u`: The first vertex.
    /// - `v`: The second vertex.
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /// Checks if the graph contains a cycle.
    ///
    /// ## Returns
    /// - `true` if the graph has a cycle, otherwise `false`.
    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        for (int v = 0; v < V; v++) {
            if (!visited.contains(v)) {
                if (hasCycleUtil(v, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /// Helper method for detecting cycles using DFS.
    ///
    /// ## Parameters
    /// - `v`: The current vertex.
    /// - `parent`: The parent of the current vertex.
    /// - `visited`: A set of visited vertices.
    ///
    /// ## Returns
    /// - `true` if a cycle is detected, otherwise `false`.
    private boolean hasCycleUtil(int v, int parent, Set<Integer> visited) {
        visited.add(v);
        for (int neighbor : adj.get(v)) {
            if (!visited.contains(neighbor)) {
                if (hasCycleUtil(neighbor, v, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    /// The main entry point of the program.
    ///
    /// - Creates a graph with `V = 4` vertices.
    /// - Adds edges between vertices.
    /// - Checks if the graph contains a cycle and prints the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        int V = 4;
        GraphCycleDetection graph = new GraphCycleDetection(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.hasCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph contains no cycles.");
        }
    }
}
