package datastructures;

import java.util.EmptyStackException;

// LIFO - Last In First Out

public class Stack {

    private class Node {
        private int data;
        private Node next;
        private Node (int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        int res = peek();
        head = head.next;
        size--;

        return res;
    }

    public int size() {
        return size;
    }
}
