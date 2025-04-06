package kruskalAlgorithmMinimalSpanningTree_in_java;

import java.util.ArrayList;
import java.util.Collections;

/**
 * # KruskalMinimumSpanningTree
 * Implements Kruskal's algorithm to find the minimal spanning tree of a graph.
 * The algorithm is designed for undirected weighted graphs and uses a Disjoint Set (Union-Find)
 * to determine connected components efficiently.
 */
public class KruskalMinimumSpanningTree {

    /**
     * Main method to execute the algorithm.
     *
     * Demonstrates the use of Kruskal's algorithm by defining a graph,
     * finding its minimal spanning tree, and displaying the result.
     *
     * @param args the command-line arguments (not used)
     */
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
        ArrayList<Edge> minimumSpanningTree = kruskal(edges, 5);

        // Display the edges of the minimal spanning tree and their total weight
        int totalWeight = 0;
        System.out.println("Edges of the minimal spanning tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println("Node " + edge.node1 + " - Node " + edge.node2 + " : Weight " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of the minimal spanning tree: " + totalWeight);
    }

    /**
     * Performs Kruskal's algorithm to find the minimal spanning tree of a graph.
     *
     * @param edges   the list of all edges in the graph
     * @param numNodes the total number of nodes in the graph
     * @return the list of edges that form the minimal spanning tree
     */
    public static ArrayList<Edge> kruskal(ArrayList<Edge> edges, int numNodes) {
        // Sort edges by increasing weight
        Collections.sort(edges);

        ArrayList<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(numNodes);

        // Process edges in order of weight
        for (Edge edge : edges) {
            int root1 = disjointSet.find(edge.node1);
            int root2 = disjointSet.find(edge.node2);

            // If the nodes belong to different sets, add the edge to the MST
            if (root1 != root2) {
                minimumSpanningTree.add(edge);
                disjointSet.union(root1, root2);
            }
        }
        return minimumSpanningTree;
    }

    /**
     * Represents an edge in an undirected weighted graph.
     */
    static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int weight;

        /**
         * Constructs an edge between two nodes with a specific weight.
         *
         * @param node1  the first node
         * @param node2  the second node
         * @param weight the weight of the edge
         */
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

    /**
     * Represents a Disjoint Set (Union-Find) data structure.
     *
     * This is used to efficiently determine connected components in a graph.
     */
    static class DisjointSet {
        private final int[] parent;
        private final int[] rank;

        /**
         * Initializes a disjoint set with a specified number of elements.
         *
         * @param size the number of elements in the set
         */
        DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        /**
         * Finds the representative element (root) of the set containing a given element.
         *
         * @param x the element to find
         * @return the root of the set
         */
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        /**
         * Merges two sets if they are not already connected.
         *
         * @param x the root of the first set
         * @param y the root of the second set
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
