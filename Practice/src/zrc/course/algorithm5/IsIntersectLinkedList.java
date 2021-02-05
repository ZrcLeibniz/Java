package zrc.course.algorithm5;

public class IsIntersectLinkedList {
    // 目的是解决两个链表是否相交的问题
    // 根据链表的拓扑结构，可以分为有环和无环链表
    // 所以我们要判断链表是否相交，需要按照链表的拓扑结构进行分情况讨论

    // 第一步：得到链表的拓扑结
    // 判断链表是否有环，如果有环返回第一个入环节点，如果没有就返回null
    public ListNode isLoop(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 按照链表有环和无环可以把相交的情况分为3种
    // 1.一个链表有环，另外一个链表无环
    // 2.两个链表都没有环
    // 3.两个链表都有环

    // 1.一个链表有环，另外一个链表无环，这种情况下，两个链表一定不可能相交


    // 2.两个链表都没有环
    public ListNode noLoop(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        int n = 0;
        while (cur1.next != null) {
            cur1 = cur1.next;
            n++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            n--;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? list1 : list2;
        cur2 = cur1 == list1 ? list2 : list1;
        n = Math.abs(n);
        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 3. 两个链表都有环
    // 分为三种拓扑
    public ListNode bothLoop(ListNode list1, ListNode loop1, ListNode list2, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 == loop2) {
            cur1 = list1;
            cur2 = list2;
            int n = 0;
            while (cur1.next != null) {
                cur1 = cur1.next;
                n++;
            }
            while (cur2.next != null) {
                cur2 = cur2.next;
                n--;
            }
            if (cur1 != cur2) {
                return null;
            }
            cur1 = n > 0 ? list1 : list2;
            cur2 = cur1 == list1 ? list2 : list1;
            n = Math.abs(n);
            while (n != 0) {
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public ListNode isIntersect(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        ListNode loop1 = isLoop(list1);
        ListNode loop2 = isLoop(list2);
        if (loop1 == null && loop2 == null) {
            return noLoop(list1, list2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(list1, loop1, list2, loop2);
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
