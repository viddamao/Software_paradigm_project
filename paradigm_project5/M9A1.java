import java.util.Scanner;

/**
 * Created by yichenzhou on 10/29/16.
 */

public class M9A1 {
    private int counter;

    public M9A1() {
        this.counter = 0;
    }

    public void increment() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            counter++;
            // Delay Each Print
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            // Print
            if (input == 0) {
                System.out.println("Delayed 1s; Counter Stop.");
                break;
            } else {
                System.out.println("Delayed 1s; User inputs: " + input + "; Counter is " + counter);
            }
        }
    }

    public static void main(String args[]) {
        M9A1 m9a1 = new M9A1();
        m9a1.increment();
    }
}
