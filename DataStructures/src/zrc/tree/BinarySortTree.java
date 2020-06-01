package zrc.tree;

public class BinarySortTree {
	private BinarySortNode root;

	public void add(BinarySortNode node) {
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

	public static void main(String[] args) {
		int[] arr = { 7, 3, 10, 12, 5, 1, 9, 0 };
		BinarySortTree binarySortTree = new BinarySortTree();
		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add(new BinarySortNode(arr[i]));
		}
		binarySortTree.infixOrder();
		binarySortTree.delNode(10);
		System.out.println();
		binarySortTree.infixOrder();
	}

	public BinarySortNode search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}

	public BinarySortNode searchParent(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(value);
		}
	}

	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			BinarySortNode targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			BinarySortNode parentNode = searchParent(value);
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

	public int delRightTreeMin(BinarySortNode node) {
		BinarySortNode target = node;
		while (target.left != null) {
			target = target.left;
		}
		delNode(target.value);
		return target.value;
	}
}

class BinarySortNode {
	int value;
	BinarySortNode left;
	BinarySortNode right;

	public BinarySortNode search(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	public BinarySortNode searchParent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParent(value);
			} else {
				return null;
			}
		}
	}

	public BinarySortNode(int value) {
		super();
		this.value = value;
	}

	public void add(BinarySortNode node) {
		if (node == null) {
			return;
		}
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

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	@Override
	public String toString() {
		return "BinarySortNode [value=" + value + "]";
	}
}