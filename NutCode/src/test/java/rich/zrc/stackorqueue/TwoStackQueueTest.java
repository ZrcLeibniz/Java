package rich.zrc.stackorqueue;

import org.junit.Test;

public class TwoStackQueueTest {
    @Test
    public void test() {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int peek = queue.peek();
        System.out.println(peek);
        int poll = queue.poll();
        System.out.println(poll);
        peek = queue.peek();
        System.out.println(peek);
        queue.add(4);
        peek = queue.peek();
        System.out.println(peek);
    }
}
