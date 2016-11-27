package Graph;

import Color.Vertex;

import java.util.Scanner;

/**
 * Created by yichenzhou on 11/6/16.
 */
public class Graph {
    private final int numOfVertex;          // number of vertices
    protected int numOfEdge;                  // number of edges
    public Bag<Integer>[] adj;              // adjacency lists

    public Graph(int V) {
        this.numOfVertex = V;
        this.numOfEdge = 0;
        this.adj = (Bag<Integer>[]) new Bag[V];  // Create array of lists
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }

    }

    public int getNumOfVertex() { return numOfVertex; }
    public int getNumOfEdge() { return numOfEdge; }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        numOfEdge++;
    }

    public void getConnectedVertex() {
        for (int i = 0; i < this.numOfVertex; i++) {
            System.out.println("Vertex " + i + ": " + adj[i].listToString());
        }
    }

    public int degree(int vertex) { return adj[vertex].size(); }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Iterable<Integer> adjLargeIndex(int v) {
        MinPQ<Integer> minPQ = new MinPQ<Integer>();
        for (int w: adj(v)) {
            minPQ.insert(w);
        }

        Bag<Integer> bag = new Bag<Integer>();
        for (int i = 0; i < adj[v].size(); i++) {
            bag.add(minPQ.delMin());
        }

        return bag;
    }

    public Iterable<Integer> adjHighDegree(int v) {
        MinPQ<Vertex> minPQ = new MinPQ<Vertex>();
        for (int w: adj[v]) {
            Vertex tmpVertex = new Vertex(w, degree(w));
            minPQ.insert(tmpVertex);
        }

        Bag<Integer> bag = new Bag<Integer>();
        for (int i = 0; i < adj[v].size(); i++) {
            bag.add(minPQ.delMin().getIndex());
        }

        return bag;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the info about graph:");
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        Graph G = new Graph(V);
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            G.addEdge(v, w);
        }
        
        System.out.println();
        G.getConnectedVertex();
    }
}
