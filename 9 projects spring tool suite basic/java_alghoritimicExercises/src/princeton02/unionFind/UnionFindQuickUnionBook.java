package princeton02.unionFind;

public class UnionFindQuickUnionBook {

	private int[] id; // access to component id (site indexed)
	private int count; // number of components

	public UnionFindQuickUnionBook(int N) { // Initialize component id array.
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int p) { // Find component name.
		while (p != id[p])
			p = id[p];
		return p;
	}

	public void union(int p, int q) { // Give p and q the same root.
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;
		id[pRoot] = qRoot;
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
