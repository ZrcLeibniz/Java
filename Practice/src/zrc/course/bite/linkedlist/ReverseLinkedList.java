package zrc.course.bite.linkedlist;

public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode solution(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
