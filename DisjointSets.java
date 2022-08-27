public class DisjointSets {
    private int[] id; // tracks parents of each node
    private int[] sz; // tracks tree size
    private int count; // tracks num of trees (sets)

    public DisjointSets(int n) {
        id = new int[n];
        sz = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            id[i] = i; // n singleton sets
            sz[i] = 1; // each set has size of 1

        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = id[rootP];
            sz[rootP] += sz[rootQ];
        }
        count--;
    }

    public int find(int p) {
        int x = p; // traveler
        while (id[x] != x) x = id[x]; // x will become the root

        while (id[p] != p) { // path compression
            int parent = id[p];
            id[p] = x;
            p = parent;
        }

        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

//    // for debugging
//    public void printIds() {
//        for (int i = 0; i < id.length; i++)
//            System.out.printf("Node %d's parent is %d%n", i, id[i]);
//    }

    public static void main(String[] args) {
        DisjointSets ds = new DisjointSets(Integer.parseInt(args[0]));

        ds.union(0, 3);
        if (ds.connected(0, 3))
            System.out.println("0 and 3 are now connected");
        ds.union(8, 9);
        ds.union(9, 3);
        ds.union(7, 3);

        System.out.printf("There are %d trees (sets)%n", ds.count());
        System.out.printf("Root of node 9 is: %d%n", ds.find(9));

//        ds.printIds();
    }
}
