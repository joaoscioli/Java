package breadthFirstGraph_in_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/// # BreadthFirstSearch
///
/// A program to perform a Breadth-First Search (BFS) on an undirected graph using an adjacency list.
///
/// ## Feature
/// - Represents an undirected graph as an adjacency list.
/// - Traverses the graph using BFS starting from a specified node.
///
/// ## Example
/// ```
/// Input Graph:
/// 0 - 1 - 3
/// |       |
/// 2       5
/// |
/// 4
///
/// BFS Traversal starting from node 0:
/// Output: 0 1 2 3 4 5
/// ```
public class BreadthFirstSearch {
    /// The main entry point of the program.
    ///
    /// - Construct a graph represented as an adjacency list.
    /// - Adds edges to the graph to from connections between nodes.
    /// - Performs BFS starting from node `0`.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Representation of the undirected graph as an adjacency list
        int numNodes = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // Add the edges of the graph
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 5);

        // Perform the width path from the start node 0
        System.out.println("Browse width (BFS) from node 0:");
        breadthFirstSearch(graph, 0);
    }
    /// Adds an undirected edge between two nodes in the graph.
    ///
    /// - Update the adjacency list to include connections for both node.
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the graph.
    /// - `node1`: The first node.
    /// - `node2`: The second node.
    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int node1, int node2) {
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }
    /// Performs Breadth-First Search (BFS) on the graph starting from a specified node.
    ///
    /// ## Algorithm
    /// 1. Initialize a `visited` array to track visited nodes.
    /// 2. Use a `Queue` to explore node in a breadth-first manner.
    /// 3. Start with the `startNode`, marking it as visited and enqueueing it.
    /// 4. While the queue is not empty:
    ///     - Dequeue a node and process it.
    ///     - Enqueue all unvisited neighbors of the current node and mark them as visited.
    ///
    /// ## Performance
    /// - **Time Complexity**: O(V + E), where `V` is the number of vertices and `E` is the number of edges.
    /// - **Space Complexity**: O(V), for the `visited` array and queue.
    ///
    /// # Parameters
    /// -`graph`: The adjacency list representation of the graph.
    /// -`startNode`: The node from which to start the BFS traversal.
    private static void breadthFirstSearch(ArrayList<ArrayList<Integer>> graph, int startNode) {
        int numNodes = graph.size();
        boolean[] visited = new boolean[numNodes];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");
            ArrayList<Integer> neighbors = graph.get(currentNode);
            for (Integer neighbor : neighbors) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

}
