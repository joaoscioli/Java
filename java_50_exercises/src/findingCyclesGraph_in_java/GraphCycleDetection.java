package findingCyclesGraph_in_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphCycleDetection {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list
    public GraphCycleDetection(int vertices) {
        V = vertices;
        adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
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
