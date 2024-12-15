package BellmanFordShortestPathAlgorithm_in_java;

import java.util.ArrayList;
import java.util.Arrays;
 /// # BellmanFordShortestPath
 /// A program to calculate the shortest paths from a starting node to all other nodes in a weighted directed graph
 /// using the Bellman-Ford algorithm. It also detects the presence of negative weight cycles in the graph.
 ///
 /// ## Features
 /// - Handles graphs with negative edge weights.
 /// - Detects negative weight cycles.
 /// - Computes shortest path distances from a single source node.
 ///
 /// ## Example
 /// ```
 /// Input Graph:
 /// 0 → 1 (6)
 /// 0 → 2 (7)
 /// 1 → 3 (5)
 /// 2 → 1 (-2)
 /// 2 → 4 (2)
 /// 3 → 4 (7)
 /// 4 → 3 (-3)
 ///
 /// Output:
 /// Minimum distances from the start node 0:
 /// Node 0: 0
 /// Node 1: 2
 /// Node 2: 7
 /// Node 3: 5
 /// Node 4: 9
 /// The graph does not contain any negative cycles.
 /// ```
public class BellmanFordShortestPath {
     /// The main entry point of the program.
     ///
     /// - Constructs a weighted directed graph.
     /// - Adds edges with weights.
     /// - Performs the Bellman-Ford algorithm.
     /// - Displays shortest distances and checks for negative cycles.
     ///
     /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Representation of the weighted directed graph as an adjacency list
        int numNodes = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<Edge>());
        }
        // Add graph edge with weights
        addWeightedEdge(graph, 0, 1, 6);
        addWeightedEdge(graph, 0, 2, 7);
        addWeightedEdge(graph, 1, 3, 5);
        addWeightedEdge(graph, 2, 1, -2);
        addWeightedEdge(graph, 2, 4, 2);
        addWeightedEdge(graph, 3, 4, 7);
        addWeightedEdge(graph, 4, 3, -3);

        // Start node
        int startNode = 0;
        // Perform the Bellman-Ford algorithm to find the minimum distances
        int[] distances = bellmanFord(graph, startNode);
        // Display minimum distances
        System.out.println("Minimum distances from the start node " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.print("Node " + i +": " + distances[i]);
        }
        // Detect negative cycles
        if (hasNegativeCycle(graph, distances)) {
            System.out.println("The graph contains a negative cycles.");
        } else {
            System.out.println("The graph does not contain any negative cycles.");
        }
    }
      ///* Adds a directed edge with a weight to the graph.
      ///
      /// ## Parameters
      /// - `graph`: The adjacency list representation of the graph.
      /// - `node1`: The source node.
      /// - `node2`: The destination node.
      /// - `weight`: The weight of the edge.
    public static void addWeightedEdge(ArrayList<ArrayList<Edge>> graph, int node1, int node2, int weight) {
        graph.get(node1).add(new Edge(node2, weight));
    }
     /// Computes the shortest paths from the start node to all other nodes using the Bellman-Ford algorithm.
     ///
     /// ## Algorithm
     /// 1. Initialize all distances to infinity (`Integer.MAX_VALUE`) except the start node, which is set to `0`.
     /// 2. For each node, relax all edges (repeat `numNodes - 1` times).
     /// 3. Return the distance array.
     ///
     /// ## Performance
     /// - **Time Complexity**: O(V × E), where `V` is the number of vertices and `E` is the number of edges.
     /// - **Space Complexity**: O(V) for the distance array.
     ///
     /// ## Parameters
     /// - `graph`: The adjacency list representation of the graph.
     /// - `startNode`: The source node for the shortest paths.
     ///
     /// ## Returns
     /// - An `int[]` array containing the shortest distances from the start node to all other nodes.
    public static int[] bellmanFord(ArrayList<ArrayList<Edge>> graph, int startNode) {
        int numNodes = graph.size();
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;
        for (int i = 0; i < numNodes; i++) {
            for (int node = 0; node< numNodes; node++) {
                for (Edge edge : graph.get(node)) {
                    if (distances[node] != Integer.MAX_VALUE && distances[node] + edge.weight < distances[edge.node]) {
                        distances[edge.node] = distances[node] + edge.weight;
                    }
                }
            }
        }
        return distances;
    }
      /// Detects the presence of negative weight cycles in the graph.
      ///
      /// ## Algorithm
      /// - Check for any edge where a shorter path is still possible.
      ///
      /// ## Parameters
      /// - `graph`: The adjacency list representation of the graph.
      /// - `distances`: The distance array obtained from the Bellman-Ford algorithm.
      ///
      /// ## Returns
      /// - `true` if a negative cycle exists; `false` otherwise.
    public static boolean hasNegativeCycle(ArrayList<ArrayList<Edge>> graph, int[] distances) {
        int numNodes = graph.size();
        for (int node = 0; node < numNodes; node++) {
            for (Edge edge : graph.get(node)) {
                if (distances[node] != Integer.MAX_VALUE && distances[node] + edge.weight < distances[edge.node]) {
                    return true;
                }
            }
        }
        return false;
    }
    /// A class to represent a directed edge with a weight in the graph.
    static class Edge {
        int node;
        int weight;
         /// Constructs an edge with the specified destination node and weight.
         ///
         /// ## Parameters
         /// - `node`: The destination node.
         /// - `weight`: The weight of the edge.
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
