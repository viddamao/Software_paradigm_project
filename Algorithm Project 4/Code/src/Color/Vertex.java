package Color;

/**
 * Created by yichenzhou on 11/27/16.
 */
public class Vertex implements Comparable<Vertex> {
    private int index;
    private int degree;

    public Vertex(int index, int degree) {
        this.index = index;
        this.degree = degree;
    }

    public int getIndex() {
        return index;
    }

    public int getDegree() {
        return degree;
    }

    public int compareTo(Vertex that) {
        if (this.getDegree() < that.getDegree()) { return  -1; }
        else if (this.getDegree() > that.getDegree()) { return 1; }
        else { return 0; }
    }

}
