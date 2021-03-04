package zrc.course.bite.linkedlist;

public class LastKNode {
    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode solution(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
