package zrc.linear.practice.LinkList;

import java.util.Iterator;

public class LinkList01<T> implements Iterable<T> {
    private Node head;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList01(){
        this.head = new Node(null, null);
        this.N = 0;
    }
}
