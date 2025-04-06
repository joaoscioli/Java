package primsAlgorithmMinimalSpanningTree_in_java;

import java.util.ArrayList;
import java.util.PriorityQueue;

/// # PrimMinimumSpanningTree
/// This program implements **Prim's Algorithm** to find the **Minimum Spanning Tree (MST)** of a weighted graph.
///
/// ## Features
/// - Uses **Prim's Algorithm** with a priority queue.
/// - Constructs the MST from an **undirected weighted graph**.
/// - Outputs the edges and total weight of the MST.
///
/// ## Complexity
/// - **Time Complexity**: O(E log V), where `E` is the number of edges and `V` is the number of vertices.
/// - **Space Complexity**: O(V + E) due to adjacency list representation.
///
/// ## Example
/// ```
/// Input:
/// Graph with 5 nodes and weighted edges.
///
/// Output:
/// Edges of the minimal spanning tree:
/// Node 1 - Node 2 : Weight 1
/// Node 0 - Node 1 : Weight 2
/// Node 2 - Node 4 : Weight 2
/// Node 2 - Node 3 : Weight 5
/// Total weight of the minimal spanning tree: 10
/// ```
public class PrimMinimumSpanningTree {

    /// The main entry point of the program.
    ///
    /// - Initializes a weighted graph.
    /// - Runs Prim’s Algorithm to compute the **Minimum Spanning Tree**.
    /// - Displays the edges and total weight of the MST.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        int numNodes = 5;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        addWeightedEdge(graph, 0, 1, 2);
        addWeightedEdge(graph, 0, 2, 3);
        addWeightedEdge(graph, 1, 2, 1);
        addWeightedEdge(graph, 1, 3, 7);
        addWeightedEdge(graph, 2, 3, 5);
        addWeightedEdge(graph, 2, 4, 2);
        addWeightedEdge(graph, 3, 4, 7);

        ArrayList<Edge> minimumSpanningTree = prim(graph);

        int totalWeight = 0;
        System.out.println("Edges of the minimal spanning tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println("Node " + edge.node1 + " - Node " + edge.node2 + " : Weight " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of the minimal spanning tree: " + totalWeight);
    }

    /// Adds an **undirected weighted edge** between two nodes in the graph.
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the graph.
    /// - `node1`: The first node of the edge.
    /// - `node2`: The second node of the edge.
    /// - `weight`: The weight of the edge.
    public static void addWeightedEdge(ArrayList<ArrayList<Node>> graph, int node1, int node2, int weight) {
        graph.get(node1).add(new Node(node2, weight));
        graph.get(node2).add(new Node(node1, weight));
    }

    /// Implements **Prim’s Algorithm** to compute the **Minimum Spanning Tree (MST)**.
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the weighted graph.
    ///
    /// ## Returns
    /// - An **ArrayList<Edge>** containing the edges of the MST.
    ///
    /// ## Algorithm
    /// - Uses a **priority queue** (min-heap) to select the smallest edge.
    /// - Iteratively adds edges to the MST, ensuring no cycles.
    /// - **Greedy Approach**: Always picks the smallest available edge.
    public static ArrayList<Edge> prim(ArrayList<ArrayList<Node>> graph) {
        int numNodes = graph.size();
        ArrayList<Edge> minimumSpanningTree = new ArrayList<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        boolean[] visited = new boolean[numNodes];

        int startNode = 0;
        visited[startNode] = true;
        for (Node neighbor : graph.get(startNode)) {
            priorityQueue.add(new Edge(startNode, neighbor.node, neighbor.weight));
        }

        while (minimumSpanningTree.size() < numNodes - 1) {
            Edge edge = priorityQueue.poll();
            if (edge == null) break;

            int node1 = edge.node1;
            int node2 = edge.node2;

            if (visited[node1] && visited[node2]) {
                continue;
            }

            minimumSpanningTree.add(edge);

            int newNode = visited[node1] ? node2 : node1;
            visited[newNode] = true;

            for (Node neighbor : graph.get(newNode)) {
                if (!visited[neighbor.node]) {
                    priorityQueue.add(new Edge(newNode, neighbor.node, neighbor.weight));
                }
            }
        }

        return minimumSpanningTree;
    }

    /// Represents a **graph node** with a connection to another node.
    static class Node {
        int node;  ///< The target node.
        int weight;  ///< The weight of the edge.

        /// Constructor for the `Node` class.
        ///
        /// @param node The target node.
        /// @param weight The weight of the edge.
        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    /// Represents an **edge** between two nodes with a weight.
    static class Edge implements Comparable<Edge> {
        int node1;  ///< The first node of the edge.
        int node2;  ///< The second node of the edge.
        int weight; ///< The weight of the edge.

        /// Constructor for the `Edge` class.
        ///
        /// @param node1 The first node of the edge.
        /// @param node2 The second node of the edge.
        /// @param weight The weight of the edge.
        Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        /// Comparison function for **sorting edges** based on weight.
        ///
        /// @param other The edge to compare with.
        /// @return `-1` if this edge is smaller, `1` if greater, `0` if equal.
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
