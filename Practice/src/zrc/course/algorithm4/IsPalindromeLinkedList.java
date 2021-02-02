package zrc.course.algorithm4;

import zrc.linear.Stack;

// 判断一个链表是否是回文结构
public class IsPalindromeLinkedList {
    private class ListNode {
        int val;
        ListNode next;
    }

    public boolean isPalindromeSolutionI(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            if (cur.val != stack.pop().val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public boolean isPalindromeII(ListNode head) {
        ListNode midNode = getMidLinkedList(head);
        if (midNode == null || midNode.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        while (midNode.next != null) {
            stack.push(midNode.next);
            midNode = midNode.next;
        }
        midNode = head;
        while (!stack.isEmpty()) {
            if (midNode.val != stack.pop().val) {
                return false;
            }
            midNode = midNode.next;
        }
        return true;
    }

    public boolean isPalindromeIII(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode midLinkedList = getMidLinkedList(head);
        ListNode secondStart = reverseLinkedList(midLinkedList.next);
        ListNode left = head;
        ListNode right = secondStart;
        boolean result = true;
        while (right != null) {
            if (left.val != right.val) {
                result = false;
            }
            right = right.next;
            left = left.next;
        }
        midLinkedList.next = reverseLinkedList(secondStart);
        return result;
    }

    private ListNode getMidLinkedList(ListNode head) {
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

    private ListNode reverseLinkedList(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = next;
            next = cur;
            cur = temp;
        }
        return next;
    }
}
