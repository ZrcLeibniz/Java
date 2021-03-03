package zrc.course.algorithm13;

import java.util.Stack;

public class Travel {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void preTravel(TreeNode root) {
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

    public void midTravel(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    TreeNode pop = stack.pop();
                    System.out.println(pop.val);
                    pop = pop.right;
                }
            }
        }
    }

    public void postTravel(TreeNode root) {
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
        }
    }

    public void morrisTravel(TreeNode root) {
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

    // morris的先序遍历
    /*
    能够一次到达的节点直接打印
    能够到达两次的节点第一次到达是打印
     */
    public void preMorrisTravel(TreeNode root) {
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
                    mostRight = null;
                }
            }
            System.out.println(cur.val + " ");
            cur = cur.left;
        }
    }

    /*
    morris遍历的中序遍历
    只能到达一次的节点直接打印
    能够到达两次的节点第二次到达的时候打印
     */
    public void midMorrisTravel(TreeNode root) {
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
            } else {
                System.out.println(cur.val + " ");
            }
            cur = cur.right;
        }
    }

    /*
    对于只能到达一次的节点，什么也不做
    对于可以到达两次的节点，在第二次到达节点的时候逆序打印其右边界
     */
    public void postMorris(TreeNode root) {
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
                    mostRight = null;
                    printEdge(cur);
                }
            }
            cur = cur.right;
        }
        printEdge(root);
    }

    private void printEdge(TreeNode node) {
        TreeNode reverse = reverse(node);
        TreeNode cur = reverse;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
        reverse(reverse);
    }

    private TreeNode reverse(TreeNode node) {
        TreeNode pre = null;
        TreeNode next = null;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    // 使用morris遍历判断一棵树是否是搜索二叉树
    public boolean isBinarySearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        Integer preValue = Integer.MIN_VALUE;
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
