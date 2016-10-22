/**
 * Created by yichenzhou on 10/22/16.
 */
public class Singleton {
    private static  Singleton instance = null;

    /***
     *  Prevent client to create instance without regulation.
     */
    private Singleton() { }

    /***
     *  Prevent client to create more than one instance.
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void printInstance() {
        if (instance == null) {
            System.out.println("Instance is null.");
        } else {
            System.out.println("Instance is " + instance);
        }
    }
}
