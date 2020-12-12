package zrc.leetcode;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 758 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 */
class SwapListNode {
    int val;
    SwapListNode next;

    SwapListNode() {
    }

    SwapListNode(int val) {
        this.val = val;
    }

    SwapListNode(int val, SwapListNode next) {
        this.val = val;
        this.next = next;
    }
}

class SwapListNodeSolution {
    public SwapListNode swapPairs(SwapListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            head.next.next = head;
            head = head.next;
            head.next.next = null;
            return head;
        }
        SwapListNode temp = head.next.next;
        head.next.next = null;
        SwapListNode pre = swapPairs(head);
        SwapListNode last = swapPairs(temp);
        pre.next.next = last;
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
