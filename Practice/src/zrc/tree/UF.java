package zrc.tree;

public class UF {
    private int[] eleAngGroup;
    private int count;

    public UF(int N) {
        this.count = N;
        this.eleAngGroup = new int[N];
        for (int i = 0; i < eleAngGroup.length; i++) {
            eleAngGroup[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return eleAngGroup[p];
    }

    public void union(int p, int q) {
         if (connected(p, q)) {
             return;
         }
        int pGroup = find(p);
        int qGroup = find(q);
        for (int i = 0; i < eleAngGroup.length; i++) {
            if (eleAngGroup[i] == pGroup) {
                eleAngGroup[i] = qGroup;
            }
        }
        this.count--;
    }
}
