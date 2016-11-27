package Color;

import Graph.Graph;
import java.util.Scanner;

/**
 * Created by yichenzhou on 11/26/16.
 */
public class ColoringTest {
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
        
        long totalG = 0;
        for (int i = 0; i < 10000; i++) {
            KColoringGreedy kcg = new KColoringGreedy(graph, numOfColor);
            long greedyBeginTime = System.nanoTime();
            kcg.toColor(graph, 0);
            long greedyEndTime = System.nanoTime();
            long greedyTime = greedyEndTime - greedyBeginTime;
            totalG += greedyTime;
        }
        long averageG = totalG/10000;

        long totalD = 0;
        for (int i = 0; i < 10000; i++) {
            KColoringDegree kcd = new KColoringDegree(graph, numOfColor);
            long degreeBeginTime = System.nanoTime();
            kcd.toColor(graph, 0);
            long degreeEndTime = System.nanoTime();
            long degreeTime = degreeEndTime - degreeBeginTime;
            totalD += degreeTime;
        }
        long averageD = totalD/10000;


        System.out.println();
        System.out.println("Greedy:" + averageG + " VS Degree: " + averageD);
        System.out.println("Degree/Greedy: " + (float)averageD/(float) averageG);
    }
}
