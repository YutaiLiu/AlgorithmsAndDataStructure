package datastructures;

public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;

    public void addFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int getFirst() {
        if (head == null) {
            throw new IllegalStateException("Linked list head is null");
        } else {
            return head.data;
        }
    }

    public Node getLastNode() {
        if (head == null) {
            throw new IllegalStateException("Linked list head is null");
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            return cur;
        }
    }

    public int getLast() {
        if (head == null) {
            throw new IllegalStateException("Linked list head is null");
        } else {
            Node cur = getLastNode();
            return cur.data;
        }
    }

    public void addBack(int data) {
        if (head == null) {
            addFront(data);
        } else {
            Node cur = getLastNode();
            Node last = new Node(data);
            cur.next = last;
        }
    }

    public int size() {
        int size = 0;
        Node node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public void clear() {
        head = null;
    }

    public void deleteValue(int data) {
        Node helper = head;
        Node preNode = head;
        while (helper != null) {
            if (helper.data == data) {
                preNode.next = helper.next;
                helper = helper.next;
            } else {
                preNode = helper;
                helper = helper.next;
            }
        }
    }

    public void print() {
        Node helper = head;
        while (helper != null) {
            System.out.println(helper.data);
            helper = helper.next;
        }
    }

}
