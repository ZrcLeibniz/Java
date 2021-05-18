package rich.zrc.stackorqueue;

import org.junit.Test;
import rich.zrc.stackorqueue.MinStack;

public class MinStackTest {
    @Test
    public void testI() {
        MinStack minStack = new MinStack();
        int[] arr = {5, 4, 3, 2, 1};
        for (int i : arr) {
            minStack.push(i);
        }
        int poll = minStack.poll();
        int min = minStack.getMin();
        System.out.println(poll);
        System.out.println(min);
        minStack.push(7);
        int min1 = minStack.getMin();
        System.out.println(min1);
        minStack.poll();
        System.out.println(minStack.getMin());
    }
}
