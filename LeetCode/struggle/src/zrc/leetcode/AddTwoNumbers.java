package zrc.leetcode;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5332 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 */
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

class AddTwoNumbersSolution {
    public static NthEndListNode addTwoNumbers(NthEndListNode l1, NthEndListNode l2) {
        NthEndListNode result = new NthEndListNode();
        NthEndListNode cur = result;
        while (l1 != null || l2 != null) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            NthEndListNode temp = new NthEndListNode(l1val + l2val);
            cur.next = temp;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        cur = result.next;
        while (cur != null) {
            if (cur.val > 9 && cur.next != null) {
                cur.val = cur.val % 10;
                cur.next.val++;
            }
            if (cur.val > 9 && cur.next == null) {
                cur.val = cur.val % 10;
                NthEndListNode listNode = new NthEndListNode(1);
                cur.next = listNode;
                break;
            }
            cur = cur.next;
        }
        return result.next;
    }

    public NthEndListNode AddTwoNumbersII(NthEndListNode l1, NthEndListNode l2) {
        NthEndListNode result = new NthEndListNode();
        NthEndListNode cur = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int sum = l1val + l2val + carry;
            carry = sum % 10;
            sum = sum / 10;
            cur.next = new NthEndListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new NthEndListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        NthEndListNode node1 = new NthEndListNode(9);
        NthEndListNode node2 = new NthEndListNode(9);
        NthEndListNode node3 = new NthEndListNode(9);
        NthEndListNode node4 = new NthEndListNode(9);
        NthEndListNode node5 = new NthEndListNode(9);
        NthEndListNode node6 = new NthEndListNode(9);
        NthEndListNode node7 = new NthEndListNode(9);
        NthEndListNode node8 = new NthEndListNode(9);
        NthEndListNode node9 = new NthEndListNode(9);
        NthEndListNode node10 = new NthEndListNode(9);
        NthEndListNode node11 = new NthEndListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        NthEndListNode listNode = addTwoNumbers(node1, node4);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
