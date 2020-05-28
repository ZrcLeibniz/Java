package zrc.tree;

public class ThreadBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Node node1 = new Node(1, "tom");
		Node node2 = new Node(3, "jack");
		Node node3 = new Node(6, "smith");
		Node node4 = new Node(8, "mary");
		Node node5 = new Node(10, "king");
		Node node6 = new Node(14, "dim");
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		Node node52 = node5;
		node2.setRight(node52);
		node3.setLeft(node6);
		
		ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
		threadBinaryTree.setRoot(node1);
		threadBinaryTree.threadedNodes();
		Node leftNode = node5.getLeft();
		Node rightNode = node5.getRight();
		System.out.println(leftNode);
		System.out.println(rightNode);
		threadBinaryTree.threadedList();
	}

}

class ThreadBinaryTree {
	private Node root;
	private Node pre = null;

	public void setRoot(Node root) {
		this.root = root;
	}

	public void threadedList() {
		Node node = root;
		while(node != null) {
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			System.out.println(node);
			while(node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	
	public void threadedNodes() {
		this.threadedNodes(root);
	}
	
	public void threadedNodes(Node node) {
		if (node == null) {
			return;
		}
		threadedNodes(node.getLeft());
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		pre = node;
		threadedNodes(node.getRight());
	}

	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}

	}

	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	public Node preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}

	public Node infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}

	public Node postOrderSearch(int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		} else {
			return null;
		}
	}

	public void delNode(int no) {
		if (root != null) {
			if (root.getNo() == no) {
				root = null;
			} else {
				root.delNode(no);
			}
		} else {
			System.out.println("空树，无法删除");
		}
	}

}

class Node {
	private int no;
	private String name;
	private Node left;
	private Node right;
	private int leftType;
	private int RightType;

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return RightType;
	}

	public void setRightType(int rightType) {
		RightType = rightType;
	}

	public Node(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}

	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	public Node preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		Node resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}

	public Node infixOrderSearch(int no) {
		Node resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;
	}

	public Node postOrderSearch(int no) {
		Node resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.no == no) {
			return this;
		}
		return resNode;
	}

	public void delNode(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if (this.left != null) {
			this.left.delNode(no);
		}
		if (this.right != null) {
			this.right.delNode(no);
		}
	}

}