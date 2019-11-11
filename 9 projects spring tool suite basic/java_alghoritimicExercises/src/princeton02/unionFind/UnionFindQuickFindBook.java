package princeton02.unionFind;

public class UnionFindQuickFindBook {

	private int[] id; // access to component id (site indexed)
	private int count; // number of components

	public UnionFindQuickFindBook(int N) { // Initialize component id array.
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

	public int find(int p) {
		return id[p];
	}

	public void union(int p, int q) { // Put p and q into the same component.
		int pID = find(p);
		int qID = find(q);
		// Nothing to do if p and q are already in the same component.
		if (pID == qID)
			return;
		// Rename p’s component to q’s name.
		for (int i = 0; i < id.length; i++)
			if (id[i] == pID)
				id[i] = qID;
		count--;
	}

	public static void main(String[] args) { // Solve dynamic connectivity problem on StdIn.

		int N = 8; // input number of sites.

		UnionFindQuickFindBook uf = new UnionFindQuickFindBook(N); // Initialize N components.

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
