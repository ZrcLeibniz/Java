
public class Test {
    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(1);
        ListNode1 listNode2 = new ListNode1(2);
        ListNode1 listNode3 = new ListNode1(4);
        ListNode1 listNode4 = new ListNode1(1);
        ListNode1 listNode5 = new ListNode1(3);
        ListNode1 listNode6 = new ListNode1(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode1 listNode11 = mergeTwoLists(listNode1, listNode4);
    }

    public static ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
        ListNode1 p1 = l1;
        ListNode1 p2 = l2;
        ListNode1 newNode = new ListNode1();
        newNode.val = l1.val > l2.val ? l2.val : l1.val;
        ListNode1 temp = newNode;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        while (p1 != null) {
            temp.next = p1;
            p1 = p1.next;
            temp = temp.next;
        }
        while (p2 != null) {
            temp.next = p2;
            p2 = p2.next;
            temp = temp.next;
        }
        return newNode.next;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}
