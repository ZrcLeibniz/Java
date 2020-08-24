package zrc.offer;

/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class JZ16 {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            ListNode front = list1;
            ListNode end = list2;
            ListNode head = new ListNode(0);
            ListNode temp = head;
            while (front != null && end != null) {
                if (front.val <= end.val) {
                    temp.next = front;
                    front = front.next;
                } else {
                    temp.next = end;
                    end = end.next;
                }
                temp = temp.next;
            }
            while (front != null) {
                temp.next = front;
                temp  =temp.next;
                front = front.next;
            }
            while (end != null) {
                temp.next = end;
                temp = temp.next;
                end = end.next;
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(20);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode listNode = Merge(node1, node5);
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
