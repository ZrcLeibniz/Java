package zrc.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	private ArrayList<String> vertxtList;
	private int[][] edges;
	private int numofEdges;
	private boolean[] isVisited;

	public Graph(int n) {
		edges = new int[n][n];
		vertxtList = new ArrayList<String>(n);
		numofEdges = 0;
		isVisited = new boolean[n];
	}

	public int getNumofVertex() {
		return vertxtList.size();
	}

	public int getnumofEdges() {
		return numofEdges;
	}

	public String getValueByIndex(int index) {
		return vertxtList.get(index);
	}

	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	public void showGraph() {
		for (int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}

	public void insertVertex(String vertex) {
		vertxtList.add(vertex);
	}

	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numofEdges++;
	}

	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertxtList.size(); j++) {
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertxtList.size(); j++) {
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	private void dfs(boolean[] isVisited, int i) {
		System.out.println(getValueByIndex(i));
		isVisited[i] = true;
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!isVisited[w]) {
				dfs(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}
	}

	public void dfs() {
		for (int i = 0; i < getNumofVertex(); i++) {
			if (!isVisited[i]) {
				dfs(isVisited, i);
			}
		}
	}

	private void bfs(boolean[] isVisited, int i) {
		int u;
		int w;
		LinkedList queue = new LinkedList();
		System.out.println(getValueByIndex(i));
		isVisited[i] = true;
		queue.addLast(i);
		while (!queue.isEmpty()) {
			u = (Integer) queue.removeFirst();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (isVisited[w]) {
					System.out.println(getValueByIndex(w));
					isVisited[w] = true;
					queue.addLast(w);
				}
				w = getNextNeighbor(u, w);
			}
		}
	}

	public void bfs() {
		for (int i = 0; i < getNumofVertex(); i++) {
			if (!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}

	public static void main(String[] args) {
		int n = 5;
		String vertexValue[] = { "A", "B", "C", "D", "E" };
		Graph graph = new Graph(n);
		for (String value : vertexValue) {
			graph.insertVertex(value);
		}
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.showGraph();
		graph.dfs();
	}

}
