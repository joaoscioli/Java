package DeepTraversalDFSGraph_in_java.readme;

import java.util.ArrayList;
import java.util.Stack;
/// # DepthFirstSearch
/// A program to perform a Depth-First Search (DFS) on an undirected graph using an adjacency list.
///
/// ## Features
/// - Represents an undirected graph as an adjacency list.
/// - Traverses the graph using DFS starting from a specified node.
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
/// DFS Traversal starting from node 0:
/// Output: 0 2 4 1 3 5
/// ```
public class DepthFirstSearch {
    /// The main entry point of the program.
    ///
    /// - Constructs a graph represented as an adjacency list.
    /// - Adds edge to the graph to from connections between nodes.
    /// - Performs DFS starting from node `0`.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Representation of the undirected graph as an adjacency list
        int numNodes = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }
        // Add the edges of the graph
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 5);

        // Perform the depth run from the start node 0
        System.out.println("Depth traversal (DFS) from node 0: ");
        depthFirstSearch(graph, 0);
    }
    /// Adds an undirected edge between two nodes in the graph.
    ///
    /// - Updates the adjacency list to include connections for both nodes.
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the graph.
    /// - `node1`: The first node.
    /// _ `node2`: The second node.
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int node1, int node2) {
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }
    /// Performs Depth-First Search (DFS) on the graph starting from a specified node.
    ///
    /// ## Algorithm
    /// 1. Use a `Stack` to explore node in a depth-first manner.
    /// 2. Mark node as visited once they are processed.
    /// 3. Push the starting node onto the stack.
    /// 4. While the stack is not empty:
    ///     - Pop a node, mark it as visited, and process it.
    ///     - Push all unvisited neighbors of the current node onto the stack.
    ///
    /// ## Performance
    /// - **Time Complexity**: O(V + E), where `V` is the number of vertices and `E` is the number of edges.
    /// - **Space Complexity**: O(V), for the `visited` array and stack.
    ///
    /// ## Parameters
    /// - `graph`: The adjacency list representation of the graph.
    /// - `startNode`: The node from which to start the DFS traversal.
    public static void depthFirstSearch(ArrayList<ArrayList<Integer>> graph, int startNode) {
        int numNodes = graph.size();
        boolean[] visited = new boolean[numNodes];
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            if (!visited[currentNode]) {
                System.out.print(currentNode + " ");
                visited[currentNode] = true;
                ArrayList<Integer> neighbors = graph.get(currentNode);
                for (Integer neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
