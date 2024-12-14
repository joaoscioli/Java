package BellmanFordShortestPathAlgorithm_in_java;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordShortestPath {
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
    public static void addWeightedEdge(ArrayList<ArrayList<Edge>> graph, int node1, int node2, int weight) {
        graph.get(node1).add(new Edge(node2, weight));
    }

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
    static class Edge {
        int node;
        int weight;
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
