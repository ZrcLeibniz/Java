package zrc.tree;

public class UF_Tree_Weighted {
    private int[] eleAndGroup;
    private int[] sz;
    private int count;

    public UF_Tree_Weighted(int[] eleAndGroup, int[] sz, int count) {
        this.sz = new int[count];
        this.count = count;
        this.eleAndGroup = new int[count];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (true) {
            if (p == eleAndGroup[p]) {
                return p;
            }
            p = eleAndGroup[p];
        }
    }

    public void union(int p, int q) {
        int findP = find(p);
        int findQ = find(q);
        if (findP == findQ) {
            return;
        }
        if (sz[findP] < sz[findQ]) {
            eleAndGroup[findP] = findQ;
            sz[findQ] += sz[findP];
        } else {
            eleAndGroup[findQ] = findP;
            sz[findP] += sz[findQ];
        }
        this.count--;
    }
}
