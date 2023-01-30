//Simplest algorithm going through every index of array during Union operation. Complexity O(n**2).

public class UnionFindEager {
    int N;
    int[] id;

    public UnionFindEager(int N) {
        this.N = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int idp = id[p];
        int idq = id[q];
        for (int i = 0; i < N; i++) {
            if (idp == id[i]) id[i] = idq;

        }
    }
}
