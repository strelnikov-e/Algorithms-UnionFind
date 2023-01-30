//Tree algorithm. Complexity O(n).

public class UnionFindTree {
    int N;
    int[] id;

    public UnionFindTree(int N) {
        this.N = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        //looking for a root nodes
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        if (!connected(p, q)) {
            id[q] = p;
        }
    }
}
