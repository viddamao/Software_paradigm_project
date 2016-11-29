package Color;

import Graph.Graph;

import java.util.Scanner;

/**
 * Created by yichenzhou on 11/19/16.
 */
public class KColoringGreedy {
    private int numOfColor;    // The number of color: 0 as the first type of color, take -1 as no color
    private int[] colored;     // The array contains types of color for each vertex in graph

    public KColoringGreedy(Graph graph, int numOfColor) {
        this.numOfColor = numOfColor;
        this.colored = new int[graph.getNumOfVertex()];
        // Initiate each vertex's color as -1, no color
        for (int i = 0; i < graph.getNumOfVertex(); i++) {
            colored[i] = -1;
        }
    }

    /***
     *  To determine if the vertex in the graph can be colored
     */
    private boolean isSafe(Graph graph, int vertex, int color) {
        for (int w: graph.adj(vertex)) {
            if (color == colored[w]) {
                return false;
            }
        }
        return true;
    }

    /***
     *  To color vertex in the graph in the recursive way
     */
    public boolean toColor(Graph graph, int vertex) {
        if (vertex == graph.getNumOfVertex()) {
            return true;
        }

        for (int c = 0; c < numOfColor; c++) {
            if (isSafe(graph, vertex, c)) {
                colored[vertex] = c;
                if (toColor(graph, vertex + 1)) {
                    return true;
                }

                colored[vertex] = -1;
            }
        }

        return false;
    }


    /***
     *  To determine if there exist the solution with number of colors
     */
    public void getResult(Graph graph) {
        if (!toColor(graph, 0)) {
            System.out.println("Solution does not exist.");
        } else {
            System.out.println("Solution exist.");
            for (int i = 0; i < colored.length; i++) {
                System.out.println("Vertex " + i + "'s color: " + colored[i]);
            }
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the info about graph: ");
        int numOfVertex = scanner.nextInt();
        int numOfEdge = scanner.nextInt();
        Graph graph = new Graph(numOfVertex);
        for (int i = 0; i < numOfEdge; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }
        System.out.println("Graph's Connecting Info:");
        graph.getConnectedVertex();
        System.out.println();

        System.out.println("Type the number of color:");
        int numOfColor = scanner.nextInt();

        KColoringGreedy kcp = new KColoringGreedy(graph, numOfColor);
        kcp.getResult(graph);
    }
}