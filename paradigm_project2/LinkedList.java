/**
 * Created by yichenzhou on 9/26/16.
 */
import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
    private Node first;
    private int count;

    private class Node {
        Item name;
        Item age;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public void push(Item name, Item age) {
        Node oldFirst = first;
        first = new Node();
        first.name = name;
        first.age = age;
        first.next = oldFirst;
        count++;
    }

    public String[] pop() {
        Item name = first.name;
        Item age = first.age;
        first = first.next;
        count--;
        String[] contents = new String[2];
        contents[0] = name.toString();
        contents[1] = age.toString();
        return contents;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item name = current.name;
            current = current.next;
            return name;
        }
    }
}


