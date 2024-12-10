package breadthFirstGraph_in_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
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

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int node1, int node2) {
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }
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
