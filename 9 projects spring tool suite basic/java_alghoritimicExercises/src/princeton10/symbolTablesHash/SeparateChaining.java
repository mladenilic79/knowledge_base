package princeton10.symbolTablesHash;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import princeton09.symbolTablesBalancedSearchTrees.RedBlackBSTWeb;

/******************************************************************************
 * Compilation: javac SeparateChainingLiteHashST.java Execution: java
 * SeparateChainingLiteHashST Dependencies: StdIn.java StdOut.java
 *
 * A symbol table implemented with a separate-chaining hash table.
 *
 * Note 1: does not support delete(). Note 2: does not do resizing.
 * 
 * % java SeparateChainingLiteHashST < tinyTale.txt
 *
 ******************************************************************************/

// SeparateChainingLiteHashST
public class SeparateChaining<Key, Value> {

	private int n; // number of key-value pairs
	private int m; // hash table size
	private Node[] st; // array of linked-list symbol tables

	// a helper linked list data type
	private static class Node {
		private Object key;
		private Object val;
		private Node next;

		public Node(Object key, Object val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	// create separate chaining hash table
	public SeparateChaining() {
		this(997);
	}

	// create separate chaining hash table with m lists
	public SeparateChaining(int m) {
		this.m = m;
		st = new Node[m];
	}

	// hash value between 0 and m-1
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	// return number of key-value pairs in symbol table
	public int size() {
		return n;
	}

	// is the symbol table empty?
	public boolean isEmpty() {
		return size() == 0;
	}

	// is the key in the symbol table?
	public boolean contains(Key key) {
		return get(key) != null;
	}

	// return value associated with key, null if no such key
	public Value get(Key key) {
		int i = hash(key);
		for (Node x = st[i]; x != null; x = x.next) {
			if (key.equals(x.key))
				return (Value) x.val;
		}
		return null;
	}

	// insert key-value pair into the table
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		int i = hash(key);
		for (Node x = st[i]; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		n++;
		st[i] = new Node(key, val, st[i]);
	}

	// delete key (and associated value) from the symbol table
	public void delete(Key key) {
		throw new UnsupportedOperationException("delete not currently supported");
	}

	// return all keys as an Iterable
	// put any princeton queue here and it will work
	public Iterable<Key> keys() {
		princeton01.fundamentals.QueueArrayWeb<Key> queue = new princeton01.fundamentals.QueueArrayWeb<Key>();
		for (int i = 0; i < m; i++) {
			for (Node x = st[i]; x != null; x = x.next) {
				queue.enqueue((Key) x.key);
			}
		}
		return queue;
	}

	/***************************************************************************
	 * Unit test client.
	 ***************************************************************************/

	public static void main(String[] args) {
		RedBlackBSTWeb<String, Integer> st = new RedBlackBSTWeb<String, Integer>();
		st.put("pera", 3);
		st.put("sima", 5);

		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}

	public static void main2(String[] args) {
		SeparateChaining<String, Integer> st = new SeparateChaining<String, Integer>(97);
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}

		// print keys
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));

	}

}
