package zrc.leetcode;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
class NthEndListNode {
    int val;
    NthEndListNode next;

    NthEndListNode() {
    }

    NthEndListNode(int val) {
        this.val = val;
    }

    NthEndListNode(int val, NthEndListNode next) {
        this.val = val;
        this.next = next;
    }
}

class RemoveNthNodeFromEndOfListSolution {
    public static NthEndListNode removeNthFromEnd(NthEndListNode head, int n) {
        Stack<NthEndListNode> stack = new Stack<>();
        NthEndListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        if (stack.size() == 1) {
            return null;
        }
        if (n == 1) {
            stack.pop();
            stack.pop().next = null;
            return head;
        }
        if (stack.size() == n) {
            return head.next;
        }
        int later = n - 2;
        while (later > 0) {
            stack.pop();
            later--;
        }
        NthEndListNode end = stack.pop();
        stack.pop();
        NthEndListNode pre = stack.pop();
        pre.next = end;
        return head;
    }

    public static NthEndListNode removeNthFromEndII(NthEndListNode head, int n) {
        NthEndListNode pre = new NthEndListNode(0);
        pre.next = head;
        NthEndListNode fast = pre;
        NthEndListNode slow = pre;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        NthEndListNode listNode1 = new NthEndListNode(1);
        NthEndListNode listNode2 = new NthEndListNode(2);
        NthEndListNode listNode3 = new NthEndListNode(3);
        NthEndListNode listNode4 = new NthEndListNode(4);
        NthEndListNode listNode5 = new NthEndListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        NthEndListNode listNode = removeNthFromEnd(listNode1, 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
