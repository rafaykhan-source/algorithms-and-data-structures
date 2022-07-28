public class DisjointSets {
    private int n; // number of elements across all sets
    private int[] parent, size; // records tree sizes and element parents

    // creating n singleton sets, each with size of 1
    public DisjointSets(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }

    // gives size of set that element resides in
    private int getSize(int e) {
        return size[find(e)];
    }

    // traverses up to the identifier of the set (root of the tree)
    public int find(int p) {
        while (p != parent[p]) p = parent[p];
        return p;
    }

    // unites two sets given two elements
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = parent[rootP];
            size[rootP] += size[rootQ];
        } else {

            parent[rootP] = parent[rootQ];
            size[rootQ] += size[rootP];
        }
    }

    // displays element, its set identifier, and tree size
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append("element: " + i + " root: " + find(i) + " size: " + getSize(i) + "\n");
        }

        return result.toString();
    }
    
    // test client
    public static void main(String[] args) {
        DisjointSets ds = new DisjointSets(30);
//        System.out.println(ds);
        ds.union(4, 9);
        ds.union(9, 12);
        ds.union(28, 1);
        ds.union(1, 3);
        System.out.println(ds);
    }
}

