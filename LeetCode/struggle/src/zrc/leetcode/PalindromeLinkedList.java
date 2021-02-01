package zrc.leetcode;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 837 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PalindromeLinkedListSolution {
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

    public boolean isPalindromeI(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (!stack.isEmpty()) {
            if (stack.pop().val != temp.val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public boolean isPalindromeII(ListNode head) {
        ListNode midListNode = findMidListNode(head);
        if (midListNode == null || midListNode.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        while (midListNode.next != null) {
            stack.push(midListNode.next);
            midListNode = midListNode.next;
        }
        midListNode = head;
        while (!stack.isEmpty()) {
            if (midListNode.val != stack.pop().val) {
                return false;
            }
            midListNode = midListNode.next;
        }
        return true;
    }

    public boolean isPalindromeIII(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstListNodeEnd = findMidListNode(head);
        ListNode secondListNodeStart = reverseListNode(firstListNodeEnd.next);
        ListNode start = head;
        ListNode end = secondListNodeStart;
        boolean result = true;
        while (result && end != null) {
            if (start.val != end.val) {
                result = false;
            }
            start = start.next;
            end = end.next;
        }
        firstListNodeEnd.next = reverseListNode(secondListNodeStart);
        return result;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
        }
        return pre;
    }

    private ListNode findMidListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
