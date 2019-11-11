package princeton02.unionFind;

public class UnionFindWeightedQuickUnionBook {
	private int[] id; // parent link (site indexed)
	private int[] sz; // size of component for roots (site indexed)
	private int count; // number of components

	public UnionFindWeightedQuickUnionBook(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int p) { // Follow links to find a root.
		while (p != id[p]) {
			id[p] = id[id[p]]; // add for path compression
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		// Make smaller root point to larger one.
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	public static void main(String[] args) { // Solve dynamic connectivity problem on StdIn.

		int N = 8; // input number of sites.

		UnionFindQuickUnionBook uf = new UnionFindQuickUnionBook(N); // Initialize N components.

		// input data
		int[][] ts = { { 1, 2 }, { 3, 4 }, { 4, 5 }, { 6, 7 }, { 2, 4 }, { 5, 7 }, { 0, 6 }, { 0, 7 } };

		for (int[] i : ts) {
			int p = i[0];
			int q = i[1];

			if (uf.connected(p, q)) {
				continue; // Ignore if connected.
			}
			uf.union(p, q); // Combine components

			System.out.println(p + " " + q); // print connection
		}

		System.out.println(uf.count() + " components"); // print total count
	}

}
