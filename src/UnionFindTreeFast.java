//Enhanced tree algorithm with flatten trees. Complexity O(logN).

public class UnionFindTreeFast {
    int N;
    int[] id;
    int[] size;

    public UnionFindTreeFast(int N) {
        this.N = N;
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        UFTreeBigEl uf = new UFTreeBigEl(10);
        System.out.println(uf.find(1));
        uf.union(1, 2);
        System.out.println(uf.find(1));
        uf.union(0, 1);
        System.out.println(uf.find(1));
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int root(int p) {
        if (p < id[p]) {
            root(id[p]);
        }
        return p;
    }

    public void union(int p, int q) {
        //compare size of the tree and add smaller to bigger ones;

        int i = root(p);
        int j = root(q);
        if (i != j) {
            if (size[i] < size[j]) {
                id[i] = j;
                size[j] += size[i];
            } else {
                id[j] = i;
                size[i] += size[j];
            }
        }
    }
}

