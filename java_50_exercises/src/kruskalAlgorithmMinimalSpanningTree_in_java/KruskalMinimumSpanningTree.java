package kruskalAlgorithmMinimalSpanningTree_in_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalMinimumSpanningTree {
    public static void main(String[] args) {
        // Representation of the undirected weighted graph as a list of edges
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 3));
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 3, 7));
        edges.add(new Edge(2, 3, 5));
        edges.add(new Edge(2, 4, 2));
        edges.add(new Edge(3, 4, 7));
        // Perform the Kruskal algorithm to find the minimal spanning tree
        ArrayList<Edge> minimumSpanningTree = kruskal(edges);
        // Display the edges of the minimal spanning tree and their total weight
        int totalWeight = 0;
        System.out.println("Edges of the minimal spanning tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println("Node " + edge.node1 + " - Node " + edge.node2 + " : Weight " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of the minimal spanning tree: " + totalWeight);
    }
    public static ArrayList<Edge> kruskal(ArrayList<Edge> edges) {
        // Sort edges by increasing weight
        Collections.sort(edges);
        int numNodes = 5; // The total number of nodes in the graph
        ArrayList<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(numNodes);
        for (Edge edge : edges) {
            int root1 = disjointSet.find(edge.node1);
            int root2 = disjointSet.find(edge.node2);
            if (root1 != root2) {
                minimumSpanningTree.add(edge);
                disjointSet.union(root1, root2);
            }
        }
        return minimumSpanningTree;
    }
    static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int weight;
        Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
