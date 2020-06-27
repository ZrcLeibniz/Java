package zrc.linear;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {
    private Node head;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator {
        private Node n;

        public LIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        head.next = null;
        this.N = 0;
    }

    public int length() {

        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T get(int i) {
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    public void insert(T t) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        Node node = new Node(t, null);
        n.next = node;
        N++;
    }

    public void insert(int i, T t) {
        Node n = head.next;
        for (int j = 0; j < i - 1; j++) {
            n = n.next;
        }
        Node node = new Node(t, n.next);
        n.next = node;
    }

    public T remove(int i) {
        Node n = head;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        Node temp = n.next;
        n.next = n.next.next;
        N--;
        return temp.item;
    }

    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }
}