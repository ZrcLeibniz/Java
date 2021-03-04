package zrc.course.bite.linkedlist;

public class PartitionList {
    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode solution(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lessHead = new ListNode();
        ListNode lessEnd = lessHead;
        ListNode moreHead = new ListNode();
        ListNode moreEnd = moreHead;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                lessEnd.next = head;
                lessEnd = lessEnd.next;
            } else {
                moreEnd.next = head;
                moreEnd = moreEnd.next;
            }
            head = next;
        }
        lessEnd.next = moreHead.next;
        return lessHead.next;
    }
}
