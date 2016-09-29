/**
 * Created by yichenzhou on 9/28/16.
 */

package com.yichen.zhou;

import java.util.Objects;

public class PriorityQueue {
    public int count;
    private Node first;
    private Node last;

    public class Node {
        protected String name;
        protected Integer priority;
        protected Node prev;
        protected Node next;
    }

    /***
     *  Constrictor for PriorityQueue
     */
    public PriorityQueue() {
        first = null;
        last = null;
    }

    /***
     *  Whether the queue is empty
     */
    public boolean empty() {
        return first == null;
    }

    /***
     *  Enqueue an element into Queue
     */
    public void enqueue(String name, Integer priority) {
        Node oldNode = first;
        first = new Node();
        first.name = name;
        first.priority = priority;
        first.prev = null;
        if (last == null) {
            first.next = null;
            last = first;
        } else {
            oldNode.prev = first;
            first.next = oldNode;
        }
        count++;
        assert queueCheck();
    }

    /***
     *  Dequeue the element with highest priority
     */
    public Node dequeue() {
        Node indexNode = first;
        for (Node n = first; n != null; n = n.next) {
            if (n.priority > indexNode.priority) {
                indexNode = n;
                //System.out.println(indexNode.name);
            }
        }
        if (empty()) {
            System.out.println("Queue Underflow.");
        } else {
            Node oldNode = indexNode;
            if (oldNode == first) {
                if (count == 1) {
                    first = null;
                    last = null;
                } else {
                    first = first.next;
                    first.prev = null;
                }
                count--;
                assert queueCheck();
                return oldNode;
            } else if (oldNode == last) {
                if (count == 1) {
                    first = null;
                    last = null;
                } else {
                    last = last.prev;
                    last.next = null;
                }
                count--;
                assert queueCheck();
                return oldNode;
            } else {
                Node preNode = indexNode.prev;
                Node aftNode = indexNode.next;
                preNode.next = aftNode;
                aftNode.prev = preNode;
                count--;
                assert queueCheck();
                return indexNode;
            }
        }
        return indexNode;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public PriorityQueue clone() {
        PriorityQueue copy = this;
        return copy;
    }
    public String toString() {
        return getClass().getName();
    }

    public int hashCode() {
        return Objects.hash(this.first.name, this.last.name);
    }

    /***
     *  Final checking for sequences inside the queue
     */
    private boolean queueCheck() {
        if (count < 0) {
            return false;
        } else if (count == 0) {
            if (first != null) return false;
            if (last != null) return false;
        } else if (count == 1) {
            if (first == null || last == null) return false;
            if (first != last) return false;
            if (first.next != null || first.prev != null) return false;
        } else {
            if (first == null || last == null) return false;
            if (first == last) return false;
            if (first.prev != null || first.next == null) return false;
            if (last.prev == null || last.next != null) return false;
            // Check consistency of nodes and counts
            int numOfNodes = 0;
            for (Node n = first; n != null && numOfNodes <= count; n = n.next) {
                numOfNodes++;
            }
            if (numOfNodes != count) return false;
        }
        return true;
    }

//    public static void main(String args[]) {
//        PriorityQueue queue = new PriorityQueue();
//        String[] names = new String[] {"Karen Rose", "Cora Faison", "Donna Jones", "Robert Lowe", "Patricia Johnston", "Maryanne Hicks", "James Mcmurray", "Maria Obando", "Lenora Reiter", "William Demers"};
//        Integer[] priorities = new Integer[] { 12, 11, 49, 31, 17, 40, 53, 77, 76, 33};
//
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(names[i], priorities[i]);
//        }
//
//        Node dequeuedNode = queue.dequeue();
//
//        System.out.println("Dequeued: The highest priority: " + dequeuedNode.priority + "; Node's name: " + dequeuedNode.name);
//        System.out.println(queue.count + " elements left in Queue.");
//
//        PriorityQueue copy = queue.clone();
//        if (queue.equals(copy)) {
//            System.out.println("Test for equal() and clone() succeed.");
//    } else {
//        System.out.println("Test for equal() failed.");
//    }
//        System.out.println("Test for toString(): " + queue.toString());
//        System.out.println("Test for hashCode(): " + queue.hashCode());
//    }
}
