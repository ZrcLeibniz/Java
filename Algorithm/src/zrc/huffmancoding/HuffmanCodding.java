package zrc.huffmancoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCodding {
	public static void main(String[] args) {
		String content = "i like like like java do you like a java";
		byte[] contentBytes = content.getBytes();
		// // System.out.println(contentBytes.length);
		// List<Node> list = getNodes(contentBytes);
		// // System.out.println(list);
		// Node createHuffmaanTree = createHuffmaanTree(list);
		// createHuffmaanTree.preOrder();
		// getCodes(createHuffmaanTree);
		// System.out.println(huffmanCodes);
		// byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
		// System.out.println(Arrays.toString(huffmanCodeBytes));
		System.out.println(Arrays.toString(contentBytes));
		System.out.println(Arrays.toString(huffmanZip(contentBytes)));
	}

	private static byte[] huffmanZip(byte[] bytes) {
		List<Node> nodes = getNodes(bytes);
		Node createHuffmaanTree = createHuffmaanTree(nodes);
		getCodes(createHuffmaanTree);
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		return huffmanCodeBytes;
	}

	private static ArrayList<Node> getNodes(byte[] bytes) {
		ArrayList<Node> nodes = new ArrayList<>();
		HashMap<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

	private static Node createHuffmaanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
			parentNode.left = leftNode;
			parentNode.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);
		}
		return nodes.get(0);
	}

	public static void preOrder(Node root) {
		if (root == null) {
			System.out.println("ºÕ·òÂüÊ÷Îª¿Õ");
		} else {
			root.preOrder();
		}
	}

	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	static StringBuilder stringBuilder = new StringBuilder();

	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			if (node.data == null) {
				getCodes(node.left, "0", stringBuilder2);
				getCodes(node.right, "1", stringBuilder2);
			} else {
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}

	private static Map<Byte, String> getCodes(Node root) {
		if (root == null) {
			return null;
		}
		getCodes(root.left, "0", stringBuilder);
		getCodes(root.right, "1", stringBuilder);
		return huffmanCodes;
	}

	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		int len;
		if (stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}
		byte[] huffmanCodeBytes = new byte[len];
		for (int i = 0, j = 0; i < stringBuilder.length(); i += 8, j++) {
			String strByte;
			if (i + 8 > stringBuilder.length()) {
				strByte = stringBuilder.substring(i);
			} else {
				strByte = stringBuilder.substring(i, i + 8);
			}
			huffmanCodeBytes[j] = (byte) Integer.parseInt(strByte, 2);
		}
		return huffmanCodeBytes;
	}

}

class Node implements Comparable<Node> {
	Byte data;
	int weight;
	Node left;
	Node right;

	public Node() {
		super();
	}

	public Node(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
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
}