package dijkstraShortestPathAlgorithm_in_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraShortestPath {
    public static void main(String[] args) {
        // Representation of the weighted directed graph as an adjacency list
        int numNodes = 6;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<Node>());
        }

        // Add graph edges with weights
        addWeightedEdge(graph, 0, 1, 2);
        addWeightedEdge(graph, 0, 2, 4);
        addWeightedEdge(graph, 1, 2, 1);
        addWeightedEdge(graph, 1, 3, 7);
        addWeightedEdge(graph, 2, 4, 3);
        addWeightedEdge(graph, 3, 4, 2);
        addWeightedEdge(graph, 4, 5, 5);

        // Start node
        int startNode = 0;

        // Perform Dijkstra's algorithm to find the minimum distances
        int[] distance = dijkstra(graph, startNode);

        // Display minimum distances
        System.out.println("Minimum distances from the start node: " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.print("Node " + i + ": " + distance[i]);
        }
    }
    public static void addWeightedEdge(ArrayList<ArrayList<Node>> graph, int node1, int node2, int weight) {
        graph.get(node1).add(new Node(node2, weight));
    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> graph, int startNode) {
        int numNodes = graph.size();
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int node = currentNode.node;
            int distance = currentNode.distance;
            if (distance > distances[node]) {
                continue;
            }
            for (Node neighbor : graph.get(node)) {
                int newDistance = distances[node] + neighbor.distance;
                if (newDistance < distances[neighbor.node]) {
                    distances[neighbor.node] = newDistance;
                    priorityQueue.add(new Node(neighbor.node, newDistance));
                }
            }
        }
        return distances;
    }
    static class Node implements Comparable<Node> {
        int node;
        int distance;
        Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
