package zrc.tree;

public class AVLTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 6, 5, 7, 8 };
		int[] arr2 = { 10, 12, 8, 9, 7, 6 };
		int[] arr3 = { 10, 11, 7, 6, 8, 9 };
		AVLTree avlTree = new AVLTree();
		for (int i = 0; i < arr2.length; i++) {
			avlTree.add(new AVLNode(arr3[i]));
		}
		avlTree.infixOrder();
		System.out.println(avlTree.getRoot().height());
		System.out.println(avlTree.getRoot().leftHeight());
		System.out.println(avlTree.getRoot().rightHeight());
		System.out.println(avlTree.getRoot());
	}
}

class AVLTree {
	private AVLNode root;

	public AVLNode getRoot() {
		return root;
	}

	public void setRoot(AVLNode root) {
		this.root = root;
	}

	public void add(AVLNode node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("ЪїПе");
		}
	}

	public AVLNode search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.AVLNodeSearch(value);
		}
	}

	public AVLNode searchParent(int value) {
		if (root == null) {
			return null;
		} else {
			return root.AVLNodeSearchParent(value);
		}
	}

	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			AVLNode targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			AVLNode parentNode = searchParent(value);
			if (targetNode.left == null && targetNode.right == null) {
				if (parentNode.left != null && parentNode.left.value == value) {
					parentNode.left = null;
				} else if (parentNode.right != null && parentNode.right.value == value) {
					parentNode.right = null;
				}
			} else if (targetNode.left != null && targetNode.right != null) {
				int min = delRightTreeMin(targetNode.right);
				targetNode.value = min;
			} else {
				if (targetNode.left != null) {
					if (parentNode != null) {
						if (parentNode.left.value == value) {
							parentNode.left = targetNode.left;
						} else {
							parentNode.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}
				} else {
					if (parentNode != null) {
						if (parentNode.left.value == value) {
							parentNode.left = targetNode.right;
						} else {
							parentNode.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}
				}
			}
		}
	}

	public int delRightTreeMin(AVLNode node) {
		AVLNode target = node;
		while (target.left != null) {
			target = target.left;
		}
		delNode(target.value);
		return target.value;
	}
}

class AVLNode {
	int value;
	AVLNode left;
	AVLNode right;

	public AVLNode(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "AVLNode [value=" + value + "]";
	}

	public int height() {
		return Math.max(left == null ? 0 : this.left.height(), right == null ? 0 : this.right.height()) + 1;
	}

	public int leftHeight() {
		if (left == null) {
			return 0;
		} else {
			return left.height();
		}
	}

	public int rightHeight() {
		if (right == null) {
			return 0;
		} else {
			return right.height();
		}
	}

	private void leftRotate() {
		AVLNode newNode = new AVLNode(value);
		newNode.left = this.left;
		newNode.right = this.right.left;
		this.value = this.right.value;
		this.right = this.right.right;
		this.left = newNode;
	}

	private void rightRotate() {
		AVLNode newNode = new AVLNode(value);
		newNode.right = this.right;
		newNode.left = this.left.right;
		this.value = this.left.value;
		this.left = this.left.left;
		this.right = newNode;
	}

	public AVLNode AVLNodeSearch(int value) {
		if (this.value == value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			} else {
				return this.left.AVLNodeSearch(value);
			}
		} else {
			if (this.right == null) {
				return null;
			} else {
				return this.right.AVLNodeSearch(value);
			}
		}
	}

	public AVLNode AVLNodeSearchParent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.AVLNodeSearchParent(value);
			} else if (value > this.value && this.right != null) {
				return this.right.AVLNodeSearchParent(value);
			} else {
				return null;
			}
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

	public void add(AVLNode node) {
		if (node == null) {
			return;
		} else {
			if (node.value < this.value) {
				if (this.left == null) {
					this.left = node;
				} else {
					this.left.add(node);
				}
			} else {
				if (this.right == null) {
					this.right = node;
				} else {
					this.right.add(node);
				}
			}
		}
		if (this.rightHeight() - this.leftHeight() > 1) {
			if (this.right != null && right.leftHeight() > right.rightHeight()) {
				this.right.rightHeight();
				leftRotate();
			} else {
				leftRotate();
			}
		} else if (this.leftHeight() - this.rightHeight() > 1) {
			if (this.left != null && left.rightHeight() > left.leftHeight()) {
				this.left.leftRotate();
				rightRotate();
			} else {
				rightRotate();
			}
		}
	}
}