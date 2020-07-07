package zrc.linear;

import zrc.sort.Quick;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private Node head;
    private int N;
    private Node last;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> oldFirst = head.next;
            head.next = oldFirst.next;
            N--;
            if (isEmpty()) {
                last = null;
            }
            return oldFirst.item;
        }
    }

    public void enqueue(T t) {
        if (last == null) {
            last = new Node(t, null);
            head.next = last;
        } else {
            Node oldLast = last;
            last = new Node(t, null);
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T> {
        private Node<T> n;

        public QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }

    private class Node<T> {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }
}
