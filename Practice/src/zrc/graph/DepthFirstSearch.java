package zrc.graph;


import java.util.ArrayList;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private ArrayList arrayList = new ArrayList();


    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (Integer integer : graph.adj(v)) {
            if (!marked(integer) == false) {
                dfs(graph, integer);
                System.out.println(v);
            }
        }

        count++;
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public DepthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.count = 0;
        dfs(graph, s);
    }
}
