package zrc.offer;

/*
输入一个链表，输出该链表中倒数第k个结点。
 */
public class JZ14 {
    public ListNode2 FindKthToTail(ListNode2 head, int k) {
        int size = 0;
        ListNode2 temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (k > size) {
            return null;
        }
        ListNode2 fast = head;
        ListNode2 slow = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode2 {
    int val;
    ListNode2 next = null;

    ListNode2(int val) {
        this.val = val;
    }
}