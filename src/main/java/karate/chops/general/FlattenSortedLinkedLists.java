package karate.chops.general;

import java.util.*;

public class FlattenSortedLinkedLists {

	public static void main(String[] args) {
		DLL n = createSortedLists();
		SLL result = flattenLists(n);
		printSLL(result);
	}

	private static DLL createSortedLists() {
		DLL root = new DLL(5);
		root.down = new DLL(7);
		root.down.down = new DLL(8);
		root.down.down.down = new DLL(30);

		root.right = new DLL(10);
		root.right.down = new DLL(20);

		root.right.right = new DLL(19);
		root.right.right.down = new DLL(22);
		root.right.right.down.down = new DLL(50);

		root.right.right.right = new DLL(28);
		root.right.right.right.down = new DLL(35);
		root.right.right.right.down.down = new DLL(40);
		root.right.right.right.down.down.down = new DLL(45);
		return root;
	}

	private static void printSLL(SLL result) {
		while (result != null) {
			System.out.println(result.value + " ");
			result = result.next;
		}
	}

	private static class SLL {
		int value;
		SLL next;

		SLL(int v) {
			value = v;
		}
	}

	private static class DLL {
		int value;
		DLL right;
		DLL down;

		DLL(int v) {
			value = v;
		}

	}

	private static SLL flattenLists(DLL n) {
		if (n == null)
			return null;
		SLL dummy = new SLL(-1);
		PriorityQueue<DLL> minHeap = new PriorityQueue<DLL>(new Comparator<DLL>() {
			public int compare(DLL d1, DLL d2) {
				return Integer.compare(d1.value, d2.value);
			}
		});
		SLL iter = dummy;
		iter.next = new SLL(n.value);
		iter = iter.next;
		if (n.right != null)
			minHeap.offer(n.right);
		if (n.down != null)
			minHeap.offer(n.down);

		while (!minHeap.isEmpty()) {
			DLL node = minHeap.poll();
			if (node.right != null)
				minHeap.offer(node.right);
			if (node.down != null)
				minHeap.offer(node.down);
			iter.next = new SLL(node.value);
			iter = iter.next;
		}
		return dummy.next;
	}
}
