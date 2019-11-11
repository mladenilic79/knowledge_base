package princeton06.priorityQueue;

import edu.princeton.cs.introcs.StdOut;

/******************************************************************************
 * Compilation: javac OrderedArrayMaxPQ.java Execution: java OrderedArrayMaxPQ
 * Dependencies: StdOut.java
 * 
 * Priority queue implementation with an ordered array.
 *
 * Limitations ----------- - no array resizing - does not check for overflow or
 * underflow.
 * 
 *
 ******************************************************************************/

public class PriorityQueueOrderedArrayWeb<Key extends Comparable<Key>> {
	private Key[] pq; // elements
	private int n; // number of elements

	// set inititial size of heap to hold size elements
	public PriorityQueueOrderedArrayWeb(int capacity) {
		pq = (Key[]) (new Comparable[capacity]);
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public Key delMax() {
		return pq[--n];
	}

	public void insert(Key key) {
		int i = n - 1;
		while (i >= 0 && less(key, pq[i])) {
			pq[i + 1] = pq[i];
			i--;
		}
		pq[i + 1] = key;
		n++;
	}

	/***************************************************************************
	 * Helper functions.
	 ***************************************************************************/
	private boolean less(Key v, Key w) {
		return v.compareTo(w) < 0;
	}

	/***************************************************************************
	 * Test routine.
	 ***************************************************************************/
	public static void main(String[] args) {
		PriorityQueueOrderedArrayWeb<String> pq = new PriorityQueueOrderedArrayWeb<String>(10);
		pq.insert("this");
		pq.insert("is");
		pq.insert("a");
		pq.insert("test");
		while (!pq.isEmpty())
			StdOut.println(pq.delMax());
	}

}
