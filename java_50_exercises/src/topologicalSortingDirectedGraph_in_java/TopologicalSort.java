package topologicalSortingDirectedGraph_in_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
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
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
    }
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
