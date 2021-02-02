package zrc.course.algorithm4;

public class PrintSortedListAllHave {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void printAll(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            System.out.println();
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                l2 = l2.next;
            } else {
                System.out.println(l1.val);
                l1 = l1.next;
                l2 = l2.next;
            }
        }
    }
}
