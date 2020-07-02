package zrc.test.linear;

public class CircleListInTest {
    public static void main(String[] args) {
        Node<String> seven = new Node<>("甘宁", null);
        Node<String> six = new Node<>("吕布", seven);
        Node<String> fifth = new Node<>("张飞", six);
        Node<String> fourth = new Node<>("关羽", fifth);
        Node<String> third = new Node<>("黄忠", fourth);
        Node<String> second = new Node<>("马超", third);
        Node<String> first = new Node<>("赵云", second);
        seven.next = third;
        Node entrance = getEntrance(first);
        System.out.println(entrance.item);
    }

    public static Node getEntrance(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                temp = first;
                continue;
            }
            if (temp != null) {
                temp = temp.next;
                if (temp.equals(slow)) {
                    break;
                }
            }
        }
        return temp;
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
