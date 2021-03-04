package zrc.course.bite.linkedlist;

public class MiddleOfTheLinkedList {
    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        int step = length / 2;
        while (step != 0) {
            head = head.next;
            step--;
        }
        return head;
    }

    private int getLength(ListNode head) {
        int result = 0;
        if (head != null) {
            head = head.next;
            result++;
        }
        return result;
    }
}
