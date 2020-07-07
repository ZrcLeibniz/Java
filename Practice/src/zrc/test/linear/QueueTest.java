package zrc.test.linear;

import zrc.linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("妞妞");
        queue.enqueue("臭宝");
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        for (String s:queue) {
            System.out.println(s);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        for (String s:queue) {
            System.out.println(s);
        }
    }
}
