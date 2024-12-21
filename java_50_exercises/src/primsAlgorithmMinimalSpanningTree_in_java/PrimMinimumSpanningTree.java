package primsAlgorithmMinimalSpanningTree_in_java;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimMinimumSpanningTree {
    public static void main(String[] args) {
        // Representation of the undirected weighted graph as an adjacency list
        int numNodes = 5;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Add graph edges with weights
        addWeightedEdge(graph, 0, 1, 2);
        addWeightedEdge(graph, 0, 2, 3);
        addWeightedEdge(graph, 1, 2, 1);
        addWeightedEdge(graph, 1, 3, 7);
        addWeightedEdge(graph, 2, 3, 5);
        addWeightedEdge(graph, 2, 4, 2);
        addWeightedEdge(graph, 3, 4, 7);

        // Perform Prim's algorithm to find the minimal spanning tree
        ArrayList<Edge> minimumSpanningTree = prim(graph);

        // Display the edges of the minimal spanning tree and their total weight
        int totalWeight = 0;
        System.out.println("Edges of the minimal spanning tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println("Node " + edge.node1 + " - Node " + edge.node2 + " : Weight " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of the minimal spanning tree: " + totalWeight);
    }

    public static void addWeightedEdge(ArrayList<ArrayList<Node>> graph, int node1, int node2, int weight) {
        graph.get(node1).add(new Node(node2, weight));
        graph.get(node2).add(new Node(node1, weight));
    }

    public static ArrayList<Edge> prim(ArrayList<ArrayList<Node>> graph) {
        int numNodes = graph.size();
        ArrayList<Edge> minimumSpanningTree = new ArrayList<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        boolean[] visited = new boolean[numNodes];

        // Start with any node
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

            // Add the edge to the minimum spanning tree
            minimumSpanningTree.add(edge);

            // Mark the new node as visited
            int newNode = visited[node1] ? node2 : node1;
            visited[newNode] = true;

            // Add edges connected to the new node
            for (Node neighbor : graph.get(newNode)) {
                if (!visited[neighbor.node]) {
                    priorityQueue.add(new Edge(newNode, neighbor.node, neighbor.weight));
                }
            }
        }

        return minimumSpanningTree;
    }

    static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
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
