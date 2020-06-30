package zrc.linear;


import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable{
    private Node head;
    private Node last;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{
        Node n;

        public TIterator() {
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
        public T item;
        public Node pre;
        public Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public TowWayLinkList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    public void clear() {
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
        this.N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return head.next.item;
        }
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        } else {
            return last.item;
        }
    }

    public void insert(T t) {
        if (isEmpty()) {
            Node newNode = new Node(t, head, null);
            last = newNode;
            head.next = last;
        } else {
            Node oldLast = last;
            Node newNode = new Node(t, oldLast, null);
            oldLast.next = newNode;
            last = newNode;
        }
        N++;
    }

    public void insert(int i, T t) {
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        Node newNode = new Node(t, pre, cur);
        pre.next = newNode;
        cur.pre = newNode;
        N++;
    }

    public T get(int i) {
        Node temp = head.next;
        for (int index = 0; index < i; index++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public int indexOf(T t) {
        Node temp = head;
        for (int index = 0; temp.next != null; index++) {
            temp = temp.next;
            if (temp.item.equals(t)) {
                return index;
            }
        }
        return -1;
    }

    public T remove(int i) {
        Node cur = head.next;
        for (int index = 0; index < i; index++) {
            cur = cur.next;
        }
        Node pre = cur.pre;
        Node next = cur.next;
        pre.next = next;
        next.pre = pre;
        N--;
        return cur.item;
    }
}
