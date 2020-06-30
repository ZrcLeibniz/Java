package zrc.linear.practice.LinkList;

import java.util.Iterator;

public class LinkList01<T> implements Iterable<T> {
    private Node head;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class LIterator implements Iterator{

        private Node n;

        public LIterator(Node n) {
            this.n = n;
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

    public LinkList01() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        head.next = null;
        N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T get(int i) {
        Node temp = head.next;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public void insert(T t) {
        insert(N, t);
    }

    public void insert(int i, T t) {
        Node temp = head;
        for (int index = 0; index < i; index++) {
            temp = temp.next;
        }
        Node node = new Node(t, temp.next);
        temp.next = node;
    }

    public T remove(int i) {
        Node temp = head;
        for (int index = 0; index < i; index++) {
            temp = temp.next;
        }
        Node node = temp;
        temp.next = temp.next.next;
        N--;
        return node.next.item;
    }

    public int indexOf(T t) {
        Node temp = head;
        for (int i = 0; temp.next != null; i++) {
            temp = temp.next;
            if (temp.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }
}
