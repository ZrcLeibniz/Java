package zrc.course.bite.linkedlist;

public class RemoveLinkedListElements {
    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode solution(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head.val == val ? head.next : head;
    }
}
