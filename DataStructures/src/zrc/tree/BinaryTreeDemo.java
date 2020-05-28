package zrc.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree = new BinaryTree();
		HeroNode heroNode1 = new HeroNode(1, "张锐驰");
		HeroNode heroNode2 = new HeroNode(2, "何丽雯");
		HeroNode heroNode3 = new HeroNode(3, "张奕凌");
		HeroNode heroNode4 = new HeroNode(4, "妞妞");
		HeroNode heroNode5 = new HeroNode(5, "何老棍");
		HeroNode heroNode6 = new HeroNode(6, "何包蛋");
		HeroNode heroNode7 = new HeroNode(7, "活腻蚊");
		HeroNode heroNode8 = new HeroNode(8, "雯雯");
		HeroNode heroNode9 = new HeroNode(9, "双枪老太婆");
		heroNode1.setLeft(heroNode2);
		heroNode1.setRight(heroNode3);
		heroNode2.setLeft(heroNode4);
		heroNode2.setRight(heroNode5);
		heroNode3.setLeft(heroNode6);
		heroNode3.setRight(heroNode7);
		heroNode4.setLeft(heroNode8);
		heroNode5.setRight(heroNode9);
		binaryTree.setRoot(heroNode1);
		binaryTree.preOrder();
		System.out.println();
		binaryTree.infixOrder();
		System.out.println();
		binaryTree.postOrder();
		System.out.println("前序遍历查找方式");
		System.out.println(binaryTree.preOrderSearch(5));
		System.out.println("中序遍历查找方式");
		System.out.println(binaryTree.infixOrderSearch(5));
		System.out.println("后序遍历查找方式");
		System.out.println(binaryTree.postOrderSearch(5));
		binaryTree.delHeroNode(10);
		System.out.println();
		binaryTree.preOrder();
	}

}

class BinaryTree {
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
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

	public HeroNode preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}

	public HeroNode infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}

	public HeroNode postOrderSearch(int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		} else {
			return null;
		}
	}
	
	public void delHeroNode(int no) {
		if(root != null) {
			if(root.getNo() == no) {
				root = null;
			}else {
				root.delHeroNode(no);
			}
		}else {
			System.out.println("空树，无法删除");
		}
	}
	
}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	public HeroNode(int no, String name) {
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

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
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

	public HeroNode preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		HeroNode resNode = null;
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

	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode = null;
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

	public HeroNode postOrderSearch(int no) {
		HeroNode resNode = null;
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

	public void delHeroNode(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if (this.left != null) {
			this.left.delHeroNode(no);
		}
		if (this.right != null) {
			this.right.delHeroNode(no);
		}
	}

}