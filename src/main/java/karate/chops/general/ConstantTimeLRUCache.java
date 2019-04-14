package karate.chops.general;

import java.util.*;

class ConstantTimeLRUCache {

	private Map<Integer, Node> cache = new HashMap<Integer, Node>();
	private int cacheCapacity;
	private int currentSize;
	private Node tail;
	private Node head;

	ConstantTimeLRUCache(int capacity) {
		cacheCapacity = capacity;
	}

	public void put(int key, String value) {
		Node n = new Node(key, value);

		if (currentSize < cacheCapacity) {
			if (head != null) {
				head.next = n;
				n.prev = head;
				head = head.next;
			} else {
				head = n;
				tail = n;
			}

			currentSize++;
			cache.put(key, n);
		} else {
			cache.remove(tail.key);
			tail = tail.next;
			tail.prev = null;
			head.next = n;
			n.prev = head;
			head = head.next;
			cache.put(key, n);
		}
	}

	public String get(int key) {

		Node n = cache.get(key);
		if (n == null)
			return null;

		if (n == head)
			return n.value;

		if (n.next != null && n.prev != null) {
			n.next.prev = n.prev;
			n.prev.next = n.next;
			n.prev = null;
			n.next = null;
		} else if (n.prev == null) {
			tail = n.next;
			n.next.prev = null;
			n.next = null;
		}

		head.next = n;
		n.prev = head;
		head = head.next;

		return n.value;
	}

	public static void main(String[] args) {
		ConstantTimeLRUCache cache = new ConstantTimeLRUCache(3);
		cache.put(1, "100");
		cache.put(2, "200");
		cache.put(3, "300");
		cache.put(4, "40");
		printQueue(cache.tail);
		System.out.println(cache.get(3));
		printQueue(cache.tail);
		cache.put(5, "5");
		printQueue(cache.tail);
		cache.put(6, "650");
		printQueue(cache.tail);
		System.out.println(cache.get(3));
		printQueue(cache.tail);
		cache.put(7, "77");
		printQueue(cache.tail);
		System.out.println(cache.get(7));
		printQueue(cache.tail);
	}

	private static void printQueue(Node n) {
		while (n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
		System.out.println("");
	}
}

class Node {
	int key;
	String value;
	Node prev;
	Node next;

	Node(int k, String s) {
		key = k;
		value = s;
	}
}