/**
 * Created by yichenzhou on 10/22/16.
 */
public class Test {
    public static void main(String args[]) {
        //Singleton client = new Singleton(); We can not create
        Singleton client = Singleton.getInstance();
        Singleton anotherClient = Singleton.getInstance();
        client.printInstance();
        anotherClient.printInstance();
        // Test whether two clients equal with each other.
        if (client.equals(anotherClient)) {
            System.out.println("Clients equal with each other.");
        } else {
            System.out.println("Clients do not equal with each other.");
        }
    }
}
