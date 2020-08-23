package zrc.offer;


import java.util.Stack;

public class JZ15 {
    /*
        输入一个链表，反转链表后，输出新链表的表头(头节点不存储数据)。
    */
    public static ListNode ReverseList2(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode next = null;
        ListNode reverseHead = new ListNode(head.val);
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
        return head;
    }

    /*
        输入一个链表，反转链表后，输出新链表的表头(头节点存储数据)。
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode reverseHead = stack.pop();
        ListNode cur = reverseHead;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = null;
            cur.next = pop;
            cur = cur.next;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverseHead = ReverseList(node1);
        ListNode temp = reverseHead;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
