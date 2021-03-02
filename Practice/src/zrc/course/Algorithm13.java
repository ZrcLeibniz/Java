package zrc.course;

import java.util.List;
import java.util.Stack;

public class Algorithm13 {
    /*
    树形dp使用前提：
        如果题目要求解目标是S规则，则求解流程可以定成以每一个节点为头节点的子树在S规则下
        的每一个答案，并且最终答案一定在其中
    树形dp套路：
        1.以某个节点X为头节点，分析答案有哪些可能性，并且这种分析师以X的左子树
        右子树和X整棵树的角度来考虑可能性的
        2.根据第一步的可能性分析，列出所需要的信息
        3.合并第二步的信息，对左树和右树提出同样的要求，并写出信息结构
        4.设计递归函数，递归函数是处理以X为头节点的情况的答案
        包括：
            (1)设计递归的base case
            (2)默认直接得到左树和右树的所有信息
            (3)以及把可能性整合
            (4)返回第三步信息结构
     */
}

// 二叉树节点间的最大距离问题
/*
从二叉树结点a出发，可以向上走或者向下走，但沿途的节点只能经过一次
到大节点b时路径上的节点个数叫做a到b的距离，那么二叉树任何两个节点之间都有距离
求整棵树上的最大距离
 */
class MaxWeightNode {
    /*
    分为两种情况：
        1.以X作为头节点，X参与时整棵树的最大距离
        2.以X作为头节点，X不参与时整棵树的最大距离
            (1)X的左树里有最大距离
            (2)X的右树里有最大距离
     */

    private class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public int maxDistance(TreeNode head) {
        return process(head).maxDistance;
    }

    private Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(maxDistance, height);
    }

    private static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
}

// 派对的最大欢乐值
/*
员工的信息定义如下：
    class Employee {
        public int happy;
        List<Employee> subordinates;
    }
公司的每一个员工都符合Employee类的描述。
公司只有唯一的老板，除过老板之外每个员工都有唯一的直接上级
初基层员工外每个员工都有一个或多个直接下级

这个公司现在要办派对，你可以决定那些员工来，那些员工不来，但是要遵循如下规则：
    (1)如果某个员工来了，那么这个员工的所有直接下级都不能来
    (2)派对的整体快乐值是在场所有员工快乐值得累加
    (3)你的目标是让派对的整体欢乐值最大
 */
class maxPartyHappy {
    private class Employee {
        int happy;
        List<Employee> subordinates;
    }

    private static class Info {
        int joinMaxHappy;
        int unJoinMaxHappy;

        public Info(int joinMaxHappy, int unJoinMaxHappy) {
            this.joinMaxHappy = joinMaxHappy;
            this.unJoinMaxHappy = unJoinMaxHappy;
        }
    }

    public int maxHappy(Employee boss) {
        Info process = process(boss);
        return Math.max(process.joinMaxHappy, process.unJoinMaxHappy);
    }

    private Info process(Employee x) {
        if (x.subordinates.isEmpty()) {
            return new Info(x.happy, 0);
        }
        int join = x.happy;
        int unJoin = 0;
        for (Employee subordinate : x.subordinates) {
            Info nextInfo = process(subordinate);
            join += nextInfo.unJoinMaxHappy;
            unJoin += Math.max(nextInfo.joinMaxHappy, nextInfo.unJoinMaxHappy);
        }
        return new Info(join, unJoin);
    }
}

class Traversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void pre(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
    }

    public void last(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> reverse = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                reverse.push(pop);
                if (pop.left != null) {
                    stack.push(pop.left);
                }
                if (pop.right != null) {
                    stack.push(pop.right);
                }
            }
            while (!reverse.isEmpty()) {
                System.out.println(reverse.pop());
            }
        }
    }

    public void mid(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root.left);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }

    /*
    Morris遍历
        一种遍历二叉树的方式，时间复杂度O(N)，额外空间复杂度O(1)
        利用原树种大量空闲指针的方式，达到节省空间的目的
    Morris遍历细节
        假设来到当前节点cur，开始时cur来到头节点位置
        1)如果cur没有左孩子，cur向右移动(cur = cur.right)
        2)如果cur有左孩子，找到左子树上最右的节点mostRight:
            a)如果mostRight的右指针指向空，让其指向cur，然后cur向左移动(cur = cur.left)
            b)如果mostRight的右指针指向cur，让其指向null，然后cur向右移动(cur = cur.right)
        3)cur为空时遍历停止
     */

    public void morris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    /*
    能够到达两次的节点，第一次到达的时候进行打印
    只能到达一次的节点直接打印
     */
    public void morrisPre(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    System.out.println(cur.val + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.val + " ");
            }
            cur = cur.right;
        }
    }

    /*
    能够到达两次的节点第二次到达的时候打印
    能够到达一次的节点直接打印
     */
    public void morrisMid(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.val + " ");
            cur = cur.right;
        }
    }

    /*
    对于不能回到自己两次的节点什么也不做
    对于可以回到自己两次的节点，我们在第二次回到它的时候逆序打印它左树的右边界
    等到遍历结束后，单独逆序打印整棵树的右边界
     */
    public void morrisPost(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(root);
    }

    private void printEdge(TreeNode x) {
        TreeNode tail = reverseEdge(x);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.println(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    // 使用morris遍历来求解一颗二叉树是否是搜索二叉树
    public boolean isBinarySearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        int preValue = Integer.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (cur.val < preValue) {
                return false;
            }
            preValue = cur.val;
            cur = cur.right;
        }
        return true;
    }
}

// 位图解决某一范围上数字的出现情况，并可以节省大量空间
/*
32位无符号数的范围是0~4294967295，现在有一个正好包含40亿个无符号整数的文件
所以在整个范围中必然存在出现过的数。可以使用最多1GB的内存
怎么找到所有未出现过的数字
 */
