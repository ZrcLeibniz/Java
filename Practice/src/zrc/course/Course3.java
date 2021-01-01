package zrc.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Course3 {

}

// 给定一个整型矩阵,请按照顺时针的方式打印矩阵
class Matrix {
    public void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printMatrix(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void printMatrix(int[][] matrix, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(matrix[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(matrix[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(matrix[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(matrix[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(matrix[curR][tC]);
                curR++;
            }
        }
    }
}

// 给定一个n * n的矩阵，请将矩阵旋转90度
class rotateMatrix {
    public void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }
    }
}

// “之”字形打印矩阵
class ZigZagSolution {
    public void printMatrixZigZag(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC : bC + 1;
            bR = bR == endR ? bR : bR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public void printLevel(int[][] matrix, int aR, int aC, int bR, int bC, boolean f) {
        if (f) {
            while (aR != bR + 1) {
                System.out.println(matrix[aR++][aC--] + " ");
            }
        } else {
            while (bC != aC + 1) {
                System.out.println(matrix[bR--][bC++] + " ");
            }
        }
    }
}

// 给定一个N * M的整型矩阵matrix和一个整数target，如果target存在返回true，如果target不存在返回false
class findSortMatrix {
    public boolean solution(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}

// 打印两个有序链表的公共部分
class printLinkedList {

    private class Node {
        int val;
        Node next;
    }

    public void solution(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                head1 = head1.next;
            } else if (head1.val < head2.val) {
                head2 = head2.next;
            } else {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}

// 给定一个链表的头节点head。请判断该链表是否为回文结构
class LinkedListPalindrome {

    private class Node {
        int val;
        Node next;
    }

    public boolean solution1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
        }
        return true;
    }

    public boolean solution2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean solution3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        Node cur = null;
        while (fast != null) {
            cur = fast.next;
            fast.next = slow;
            slow = fast;
            fast = cur;
        }
        cur = slow;
        fast = head;
        boolean res = true;
        while (fast != null && slow != null) {
            if (slow.val != fast.val) {
                res = false;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        slow = cur.next;
        cur.next = null;
        while (slow != null) {
            fast = slow.next;
            slow.next = cur;
            cur = slow;
            slow = fast;
        }
        return res;
    }
}

// 给定一个单向链表的头节点head，再给定一个整数pivot。实现一个调整链表的函数:
// 将链表调整为左部分都是值小于pivot的节点。中间部分都是值等于pivot的节点。右部分都是值大于pivot的节点
class LinkedListTran {

    private class Node {
        int val;
        Node next;
    }

    // 普通
    public Node solution1(Node head, int pivot) {
        ArrayList<Node> temp = new ArrayList<>();
        while (head != null) {
            Node cur = head.next;
            temp.add(head);
            head.next = null;
            head = cur;
        }
        int left = -1;
        int right = temp.size();
        int cur = 0;
        while (cur < right) {
            if (temp.get(cur).val == pivot) {
                cur++;
            } else if (temp.get(cur).val < pivot) {
                int tran = temp.get(cur).val;
                temp.get(cur++).val = temp.get(++left).val;
                temp.get(left).val = tran;
            } else if (temp.get(cur).val > pivot) {
                int tran = temp.get(cur).val;
                temp.get(cur).val = temp.get(--right).val;
                temp.get(right).val = right;
            }
        }
        for (int i = 0; i < temp.size() - 1; i++) {
            temp.get(i).next = temp.get(i + 1);
        }
        return temp.get(0);
    }

    // 进阶:在左中右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点的先后次序一样
    // 时间复杂度要求O(N)\空间复杂度要求O(1)
    public Node listPartition(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
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
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }
}

// 复制含有随机指针节点的链表
class copyRandLinkedList {

    private class Node {
        int val;
        Node next;
        Node rand;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node solution1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node solution2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
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

// 给定两个单链表（可能有环）的头节点，如果两个链表相交，请返回相交的第一个节点，如果不相交，返回null
// 时间复杂度O(M+N)/空间复杂度O(1)
class LinkedListIsIntersect {
    private class Node {
        int val;
        Node next;
    }

    public Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head2;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
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
}