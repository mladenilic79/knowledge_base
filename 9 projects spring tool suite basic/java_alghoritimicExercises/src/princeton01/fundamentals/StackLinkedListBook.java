package princeton01.fundamentals;

import java.util.Iterator;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class StackLinkedListBook<Item> implements Iterable<Item> {

	private Node first; // top of stack (most recently added node)
	private int N; // number of items

	private class Node { // nested class to define nodes
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	} // Or: N == 0.

	public int size() {
		return N;
	}

	public void push(Item item) { // Add item to top of stack.
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop() { // Remove item from top of stack.
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	// test
	public static void main(String[] args) {
		StackLinkedListBook<String> s = new StackLinkedListBook<String>();
		s.push("jedan");
		s.push("dva");
		s.push("tri");
		String pop = s.pop();
		System.out.println(pop);
		System.out.println(s.size());
		for (String string : s) {
			System.out.println(string);
		}
	}

	// test princeton standard library main (can't make it work)
	public static void main2(String[] args) { // Create a stack and push/pop strings as directed on StdIn.
		StackLinkedListBook<String> s = new StackLinkedListBook<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
