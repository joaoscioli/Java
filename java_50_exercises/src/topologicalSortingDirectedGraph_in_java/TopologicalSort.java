package topologicalSortingDirectedGraph_in_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/// # TopologicalSort
/// A program to perform topological sorting on a directed acyclic graph (DAG) using Kahn's Algorithm.
///
/// ## Features
/// - Represents a directed graph as an adjacency list.
/// - Computes the topological order of nodes in a DAG.
///
/// ## Example
/// ```
/// Input Graph:
/// 5 → 2 → 3 → 1
/// ↓    ↓
/// 0    4 → 1
///
/// Topological sort order:
/// Output: [5, 4, 2, 0, 3, 1]
/// ```
public class TopologicalSort {
    /// The main entry point of the program.
    ///
    /// - Constructs a directed graph represented as an adjacency list.
    /// - Adds edges to define relationships between nodes.
    /// - Performs topological sorting on the graph and displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Representation of the directed graph as an adjacency list
        int numNodes = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Add the edges of the graph
        addEdge(graph, 5, 2);
        addEdge(graph, 5, 0);
        addEdge(graph, 4, 0);
        addEdge(graph, 4, 1);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);

        // Perform the topological sort and display the result
        ArrayList<Integer> topologicalOrder = topologicalSort(graph);
        System.out.println("Topological sort order: " + topologicalOrder);
    }
    /// Adds a directed edge from the source node to the destination node in the graph.
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the graph.
    /// - `source`: The source node.
    /// - `destination`: The destination node.
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
    }
    /// Performs topological sorting on a directed acyclic graph (DAG) using Kahn's Algorithm.
    ///
    /// ## Algorithm
    /// 1. Compute the in-degree for each node.
    /// 2. Add all nodes with an in-degree of `0` to a queue.
    /// 3. While the queue is not empty:
    ///     - Remove a node from the queue, add it to the topological order.
    ///     - Decrease the in-degree of its neighbors.
    ///     - If a neighbor's in-degree becomes `0`, add it to the queue.
    ///
    /// ## Performance
    /// - **Time Complexity**: O(V + E), where `V` is the number of vertices and `E` is the number of edges.
    /// - **Space Complexity**: O(V + E), for the adjacency list and in-degree array.
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the graph.
    ///
    /// ## Returns
    /// - An `ArrayList` containing the nodes in topological order.
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> graph) {
        int numNodes = graph.size();
        int[] inDegree = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            ArrayList<Integer> neighbors = graph.get(i);
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numNodes; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder.add(node);
            ArrayList<Integer> neighbors = graph.get(node);
            for (int neighbor : neighbors) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return topologicalOrder;
    }
}
