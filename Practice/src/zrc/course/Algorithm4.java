package zrc.course;

/*
排序的总结
    冒泡排序：时间复杂度(O(N^2)) 空间复杂度(O(1)) 稳定的
    选择排序：时间复杂度(O(N^2)) 空间复杂度(O(1)) 不稳定的
    插入排序：时间复杂度(O(N^2)) 空间复杂度O(1) 稳定的
    归并排序：时间复杂度(O(N*logN)) 空间复杂度O(N) 稳定的
    堆排序：时间复杂度(O(N*logN)) 空间复杂度O(1) 不稳定的
    快速排序：时间复杂度(O(N*longN)) 空间复杂度(O(logN)) 不稳定的
    桶排序：稳定的

   注：
      1.归并排序的额外空间复杂度可以变成O(1)，十分复杂，可以参考“归并排序 内部缓存法”，但是会让归并排序失去稳定的特性
      2.快速排序可以做到稳定性，同样十分复杂， 可以参考“01-stable sort”，但是会让快速排序的空间复杂度提升至O(N)
      3.所有的改进都不重要，目前没有找到时间复杂度O(N*logN),，额外空间复杂度O(1)且稳定的排序
 */

/*
哈希表：
    1）哈希表在使用层面上可以理解为一种集合结构
    2）如果只key，没有伴随数据value，可以使用HashSet结构
    3）如果即有key，又有伴随数据value，可以使用HashMap结构
    4）有无伴随数据，是HashMap和HashSet唯一的区别，底层的实际结构是一回事
    5）使用哈希表增删改查的操作，可以认为时间复杂度为O(1)，但是常数时间比较大
    6）放入哈希表的东西，如果是基础类型，内部按值传递，内存占用就是这个东西的大小
    7）放入哈希表的东西，如果不是基础数据类型，内部按引用传递，内存占用是这个东西内存地址的大小
 */

import java.util.HashMap;
import java.util.Stack;

/*
有序表：
    1）有序表在使用层面上可以理解为一种集合结构
    2）如果只有key，没有value，可以是同TreeSet结构
    3）如果既有key，又有伴随数据value，可以使用TreeMap结构
    4）有无伴随数据，是TreeMap和TreeSet唯一的区别，底层的实际结构是一回事
    5）有序表和哈希表的区别是，有序表把key按照顺序组织起来，而哈希表完全按不组织
    6）红黑树、AVL树、size-balance-tree和跳表等属于有序表结构，只是底层具体实现不同
    7）放入有序表的东西，如果是基础类型，内部按值传递，内存占用就是这个东西的大小
    8）放入有序表的东西，如果不是基础类型，就必须提供比较器，内部按照引用传递，内存占用就是这个东西内存地址的大小
    9）不管是什么底层具体实现，只要是有序表，都有一下固定的基本功能和固定的时间复杂度O(logN)
 */
public class Algorithm4 {

}


// 打印两个有序链表的公共部分
class printSortedListAllHave {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void solution(ListNode l1, ListNode l2) {
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

// 判断一个链表是不是回文结构
class isPalindromeLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean solutionI(ListNode head) {
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
            if (temp.val == stack.pop().val) {
                temp = temp.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean solutionII(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode right = head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean solutionIII(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        ListNode n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n2 = n2.next;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}

// 将单向链表按照某值划分成左边小、中间相等、右边大的形式
class PartLinkedList {
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

    public ListNode solution(ListNode head, int pivot) {
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode mH = null;
        ListNode mT = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }
}

// 复制含有随机节点的链表
class CopyRandomLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode rand;

        public ListNode(int val, ListNode next, ListNode rand) {
            this.val = val;
            this.next = next;
            this.rand = rand;
        }

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

    public ListNode solution(ListNode head) {
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
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        ListNode res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}