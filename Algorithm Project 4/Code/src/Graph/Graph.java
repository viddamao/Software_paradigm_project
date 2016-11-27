package Graph;

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

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Iterable<Integer> adjL(int v) {
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

}
