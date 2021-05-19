package datastructures;

import java.util.EmptyStackException;

public class Queue {

    private class Node {
        private int data;
        private Node next;
        private Node (int data) {
            this.data = data;
        }
    }

    private Node head; // remove things here
    private Node tail; // add things here

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int res = peek();
        if (head == tail) {
            head = null;
            tail = head;
        } else {
            head = head.next;
        }

        return res;
    }
}
