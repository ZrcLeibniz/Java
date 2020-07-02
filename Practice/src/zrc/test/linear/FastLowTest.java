package zrc.test.linear;

public class FastLowTest {
    public static void main(String[] args) {

        Node<String> seven = new Node<>("甘宁", null);
        Node<String> six = new Node<>("吕布", seven);
        Node<String> fifth = new Node<>("张飞", six);
        Node<String> fourth = new Node<>("关羽",fifth);
        Node<String> third = new Node<>("黄忠", fourth);
        Node<String> second = new Node<>("马超", third);
        Node<String> first = new Node<>("赵云", second);

        String mid = getMid(first);
        System.out.println(mid);
    }

    public static String getMid(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
