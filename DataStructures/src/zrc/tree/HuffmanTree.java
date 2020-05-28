package zrc.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		HuffmanNode root = createHuffmanTree(arr);
		root.preOrder();
	}

	public static HuffmanNode createHuffmanTree(int[] arr) {
		List<HuffmanNode> nodes = new ArrayList<HuffmanNode>();
		for (int value : arr) {
			nodes.add(new HuffmanNode(value));
		}
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			HuffmanNode leftNode = nodes.get(0);
			HuffmanNode rightNode = nodes.get(1);
			HuffmanNode parentNode = new HuffmanNode(leftNode.value + rightNode.value);
			parentNode.left = leftNode;
			parentNode.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);
		}
		return nodes.get(0);
	}

	public static void preOrder(HuffmanNode root) {
		if (root == null) {
			System.out.println("赫夫曼树为空，无法遍历");
		} else {
			root.preOrder();
		}
	}
}

class HuffmanNode implements Comparable<HuffmanNode> {
	int value;
	HuffmanNode left;
	HuffmanNode right;

	public HuffmanNode(int value) {
		super();
		this.value = value;
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

	@Override
	public String toString() {
		return "HuffmanNode [value=" + value + "]";
	}

	@Override
	public int compareTo(HuffmanNode o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
}