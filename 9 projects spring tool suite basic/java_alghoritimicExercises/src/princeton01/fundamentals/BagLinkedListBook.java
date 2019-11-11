package princeton01.fundamentals;

import java.util.Iterator;

public class BagLinkedListBook<Item> implements Iterable<Item> {

	private Node first; // first node in list

	private class Node {
		Item item;
		Node next;
	}

	public void add(Item item) { // same as push() in Stack
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

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

		BagLinkedListBook<String> bag = new BagLinkedListBook<>();
		bag.add("sima");
		bag.add("simic");
		Iterator<String> iter = bag.iterator();
		while (iter.hasNext()) {
			String st = (String) iter.next();
			System.out.println(st);
		}

	}
}
