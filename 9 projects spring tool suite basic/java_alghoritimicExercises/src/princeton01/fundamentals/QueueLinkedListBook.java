package princeton01.fundamentals;

import java.util.Iterator;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

// FIFO queue
public class QueueLinkedListBook<Item> implements Iterable<Item> {

	private Node first; // link to least recently added node
	private Node last; // link to most recently added node
	private int N; // number of items on the queue

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

	public void enqueue(Item item) { // Add item to the end of the list.
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}

	public Item dequeue() { // Remove item from the beginning of the list.
		Item item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
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

	public static void main(String[] args) {

		QueueLinkedListBook<String> q = new QueueLinkedListBook<String>();
		q.enqueue("jedan");
		q.enqueue("dva");
		q.enqueue("tri");
		String string = q.dequeue();
		System.out.println(string);
		for (String str : q) {
			System.out.println(str);
		}

	}

	public static void main2(String[] args) { // Create a queue and enqueue/dequeue strings.
		QueueLinkedListBook<String> q = new QueueLinkedListBook<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty())
				StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}

}
