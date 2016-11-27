package Color;

import Graph.Graph;
import Graph.MinPQ;

import java.util.Scanner;

/**
 * Created by yichenzhou on 11/26/16.
 */
public class KColoringDegree {
    private int numberOfColor;
    private int[] colored;

    private int coloredCount;
    private int[] frequency;

    public KColoringDegree(Graph graph, int numberOfColor) {
        this.numberOfColor = numberOfColor;
        this.colored = new int[graph.getNumOfVertex()];
        this.coloredCount = 0;
        this.frequency = new int[numberOfColor];

        // Initiate each vertex's color as -1, no color
        for (int i = 0; i < graph.getNumOfVertex(); i++) {
            colored[i] = -1;
        }
    }

    /***
     *  Get vertex's available colors by eliminating the colors used in the adjacent vertexes
     */
    private MinPQ<Color> getAvailableColors(Graph graph, int vertex) {
        // Find colors used in adjacent vertexes
        int numOfAdj = graph.adj[vertex].size();
        int[] adjColors = new int[numOfAdj];
        int index = 0;
        for (int w: graph.adj(vertex)) {
            adjColors[index++] = colored[w];
        }

        // Mark the same color in the adjacent colors
        index = 0;
        for (int i = 0; i < numOfAdj; i++) {
            if (adjColors[i] != -1) {
                index++;
                for (int j = i + 1; j < numOfAdj; j++) {
                    if (adjColors[j] == adjColors[i]) {
                        adjColors[j] = -1;
                    }
                }
            }
        }

        // Mark the used color in the "colored" array
        int[] tmpColored = new int[numberOfColor];
        for (int i = 0; i < numberOfColor; i++) {
            tmpColored[i] = i;
        }
        for (int i = 0; i < numOfAdj; i++) {
            if (adjColors[i] != -1) {
                tmpColored[adjColors[i]] = -1;
            }
        }

        // Insert and Return Unique Colors in MinPQ
        MinPQ<Color> pq = new MinPQ<Color>();
        for (int i = 0; i < tmpColored.length; i++) {
            if (tmpColored[i] != -1) {
                Color color = new Color(tmpColored[i]);
                pq.insert(color);
            }
        }
        return pq;
    }

    /***
     *  To color vertexes in the recursive way
     */
    public boolean toColor(Graph graph, int vertex) {
        MinPQ<Color> pq = getAvailableColors(graph, vertex);
        if (pq.size() == 0) { return false; }
        int freqLowestColor = pq.min().getIndex();
        colored[vertex] = freqLowestColor;
        frequency[freqLowestColor] += 1;
        coloredCount++;

        for (int w: graph.adjL(vertex)) {
            if (colored[w] == -1) {
                toColor(graph, w);
            }
        }

        if (coloredCount == graph.getNumOfVertex()) {
            return true;
        }
        return false;
    }

    /***
     *  Show the solution of coloring if it exists.
     */
    public void getResult(Graph graph) {
        if (toColor(graph, 0)) {
            System.out.println("Solution exist.");
            for (int i = 0; i < graph.getNumOfVertex(); i++) {
                System.out.println("Vertex " + i + "'s color: " + colored[i]);
            }
        } else {
            System.out.println("Solution does not exist.");
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

        KColoringDegree kcd = new KColoringDegree(graph, numOfColor);
        kcd.getResult(graph);
    }

}
