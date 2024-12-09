package DeepTraversalDFSGraph_in_java.readme;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {
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
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int node1, int node2) {
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }
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
