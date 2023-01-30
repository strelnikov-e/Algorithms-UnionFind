//Enhanced tree algorithm with flatten trees. Complexity O(logN).

public class UFTreeBigEl {
    int N;
    int[] id;
    int[] size;

    public UFTreeBigEl(int N) {
        this.N = N;
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    // tests
    public static void main(String[] args) {
        UFTreeBigEl uf = new UFTreeBigEl(10);
        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        uf.union(1, 2);
        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        uf.union(0, 1);
        System.out.println(uf.find(1));
        uf.union(7, 4);
        uf.union(6, 5);
        System.out.println(uf.find(5));
        uf.union(5, 7);
        System.out.println(uf.find(5));
        uf.union(0, 4);
        System.out.println(uf.find(4));
    }

    public int find(int p) {
        while (p < id[p]) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i != j) {
            if (i < j) {
                id[i] = j;
            } else {
                id[j] = i;
            }
        }
    }
}


