package zrc.course.algorithm4;

import java.util.HashMap;

public class CopyRandomLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode rand;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val, ListNode next, ListNode rand) {
            this.val = val;
            this.next = next;
            this.rand = rand;
        }
    }

    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public ListNode solutionII(ListNode head) {
         if (head == null) {
             return null;
         }
         ListNode cur = head;
         ListNode next = null;
         while (cur != null) {
             next = cur.next;
             cur.next = new ListNode(cur.val);
             cur.next.next = next;
             cur = next;
         }
         cur = head;
         ListNode curCopy = null;
         while (cur != null) {
             curCopy = cur.next;
             next = curCopy.next;
             curCopy.rand = cur.rand == null ? null : cur.rand.next;
             cur = next;
         }
         cur = head;
         ListNode result = cur.next;
         while (cur != null) {
             curCopy = cur.next;
             next = curCopy.next;
             cur.next = next;
             curCopy.next = next == null ? null : next.next;
             cur = next;
         }
         return result;
    }
}
