package dijkstraShortestPathAlgorithm_in_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/// # DijkstraShortestPath
/// Implementation of Dijkstra's algorithm to find the shortest path in a weighted directed graph.
///
/// ## Features
/// - Uses a priority queue (min-heap) to efficiently find the shortest path.
/// - Supports graphs represented as adjacency lists.
/// - Computes the minimum distance from a given start node to all other nodes.
///
/// ## Example
/// ```
/// Input:
/// Graph with weighted edges:
/// (0 -> 1, weight 2)
/// (0 -> 2, weight 4)
/// (1 -> 2, weight 1)
/// (1 -> 3, weight 7)
/// (2 -> 4, weight 3)
/// (3 -> 4, weight 2)
/// (4 -> 5, weight 5)
///
/// Start node: 0
///
/// Output:
/// Minimum distances:
/// Node 0: 0
/// Node 1: 2
/// Node 2: 3
/// Node 3: 9
/// Node 4: 6
/// Node 5: 11
/// ```
public class DijkstraShortestPath {

    /// The main entry point of the program.
    ///
    /// - Initializes a weighted directed graph.
    /// - Executes Dijkstra's algorithm from a given start node.
    /// - Prints the shortest distance from the start node to all other nodes.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Representation of the weighted directed graph as an adjacency list
        int numNodes = 6;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
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
            System.out.println("Node " + i + ": " + distance[i]);
        }
    }

    /// Adds a weighted edge to the graph.
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the graph.
    /// - `node1`: The source node.
    /// - `node2`: The destination node.
    /// - `weight`: The weight of the edge.
    public static void addWeightedEdge(ArrayList<ArrayList<Node>> graph, int node1, int node2, int weight) {
        graph.get(node1).add(new Node(node2, weight));
    }

    /// Implements Dijkstra's algorithm to find the shortest path from a given start node.
    ///
    /// ## Algorithm
    /// 1. Initialize all node distances as infinity (`Integer.MAX_VALUE`), except for the start node (distance `0`).
    /// 2. Use a priority queue to process the nodes with the shortest known distance.
    /// 3. Update neighboring nodes if a shorter path is found.
    /// 4. Repeat until all nodes are processed.
    ///
    /// ## Complexity
    /// - **Time Complexity**: O((V + E) log V), where V is the number of vertices and E is the number of edges.
    /// - **Space Complexity**: O(V) (for distance storage and priority queue).
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the graph.
    /// - `startNode`: The node from which shortest paths are calculated.
    ///
    /// ## Returns
    /// - An array where the value at index `i` represents the shortest distance from `startNode` to node `i`.
    public static int[] dijkstra(ArrayList<ArrayList<Node>> graph, int startNode) {
        int numNodes = graph.size();
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startNode, 0));

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

    /// Represents a node in the graph with its associated distance.
    static class Node implements Comparable<Node> {
        int node;
        int distance;

        /// Constructs a new node with a specified destination and distance.
        ///
        /// ## Parameters
        /// - `node`: The node identifier.
        /// - `distance`: The weight (cost) to reach this node.
        Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        /// Compares nodes based on their distance for priority queue ordering.
        ///
        /// @param other Another node to compare with.
        /// @return A negative integer, zero, or a positive integer if this node's distance is less than, equal to, or greater than the other node's distance.
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
