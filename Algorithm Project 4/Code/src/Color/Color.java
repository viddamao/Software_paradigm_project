package Color;

/**
 * Created by yichenzhou on 11/25/16.
 */
public class Color implements Comparable<Color> {
    private int index;
    private int frequency;
    public Color(int index) {
        this.index = index;
        this.frequency = 0;
    }

    public int getIndex() { return index; }

    public int getFrequency() { return frequency; }

    public int compareTo(Color that) {
        if (this.getFrequency() < that.getFrequency()) { return  -1; }
        else if (this.getFrequency() > that.getFrequency()) { return 1; }
        else { return 0; }
    }
}
