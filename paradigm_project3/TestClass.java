package paradigm_project3;

/**
 * Created by yichenzhou on 9/28/16.
 */
public class TestClass {
    public static void main(String args[]) {
        PriorityQueue queue = new PriorityQueue();
        String[] names = new String[] {"Karen Rose", "Cora Faison", "Donna Jones", "Robert Lowe", "Patricia Johnston", "Maryanne Hicks", "James Mcmurray", "Maria Obando", "Lenora Reiter", "William Demers"};
        Integer[] priorities = new Integer[] { 12, 11, 49, 31, 17, 40, 53, 77, 76, 33};

        for (int i = 0; i < 10; i++) {
            queue.enqueue(names[i], priorities[i]);
        }

        PriorityQueue.Node dequeuedNode = queue.dequeue();

        System.out.println("Dequeued: The highest priority: " + dequeuedNode.priority + "; Node's name: " + dequeuedNode.name);
        System.out.println(queue.count + " elements left in Queue.");
        PriorityQueue copy = queue.clone();

        System.out.println("Test for clone(): " + copy.toString());
        if (queue.equals(copy)) {
            System.out.println("Test for equal() and clone() succeed.");
        } else {
            System.out.println("Test for equal() failed.");
        }
        System.out.println("Test for toString(): " + queue.toString());
        System.out.println("Test for hashCode(): " + queue.hashCode());
        
    }


}
