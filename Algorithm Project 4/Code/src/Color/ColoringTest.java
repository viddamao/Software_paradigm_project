package Color;

import Graph.Graph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
/**
 * Created by yichenzhou on 11/26/16.
 */
public class ColoringTest {
    public static void main(String args[]) throws Exception {

        int count = 0;
        Graph graph = new Graph(1);
        BufferedReader br = null;

        String fileName = "1500.txt";
        
        try {
        br = new BufferedReader(new FileReader(fileName));
        
        
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {

            if (count == 0){
                int numOfVertex = Integer.valueOf(sCurrentLine.split("\\s+")[2]);
                int numOfEdge = Integer.valueOf(sCurrentLine.split("\\s+")[3]);
                graph = new Graph(numOfVertex);
                System.out.println("graph");
                System.out.println(numOfVertex);
            } else {
                 
                  String[] content = sCurrentLine.split("\\s+");
                 
                  int v = Integer.valueOf(content[1]);
                  v -= 1;

                  int w = Integer.valueOf(content[2]);
                  w -= 1;
                  graph.addEdge(v, w);
            }
            count += 1;
        } } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());}

        
        System.out.println("Graph's Connecting Info:");
        graph.getConnectedVertex();
        System.out.println();
        int numOfColor = 100;



        long totalG = 0;

        KColoringGreedy kcg1 = new KColoringGreedy(graph, numOfColor);
        if (kcg1.getResult(graph)) {
            for (int i = 0; i < 10000; i++) {
                KColoringGreedy kcg = new KColoringGreedy(graph, numOfColor);
                long greedyBeginTime = System.nanoTime();
                kcg.toColor(graph, 0);
                long greedyEndTime = System.nanoTime();
                long greedyTime = greedyEndTime - greedyBeginTime;
                totalG += greedyTime;
            }
            System.out.println("Greedy Max: " + kcg1.getMaxNum());
        }
        long averageG = totalG/10000;

        long totalD = 0;
        KColoringDegree kcd1 = new KColoringDegree(graph, numOfColor);
        if (kcd1.getResult(graph)) {
            for (int i = 0; i < 10000; i++) {
                KColoringDegree kcd = new KColoringDegree(graph, numOfColor);
                long degreeBeginTime = System.nanoTime();
                kcd.toColor(graph, 0);
                long degreeEndTime = System.nanoTime();
                long degreeTime = degreeEndTime - degreeBeginTime;
                totalD += degreeTime;
            }
            System.out.println("Degree Max: " + kcd1.getMaxNum());
        }
        long averageD = totalD/10000;


        System.out.println();
        System.out.println("File Name: " + fileName);
        System.out.println("Graph's Degree Standard Deviation: " + graph.degreeStandardDeviation());
        System.out.println("Greedy:" + averageG + " VS Degree: " + averageD);
        System.out.println("Degree/Greedy: " + (float)averageD/(float) averageG);
    }

}