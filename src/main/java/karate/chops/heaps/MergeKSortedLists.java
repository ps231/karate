package karate.chops.heaps;

import java.util.*;
import karate.chops.linkedlist.ListNode;
import karate.chops.linkedlist.ListNodeHelper;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode l1 = ListNodeHelper.createList(1);
		ListNode l2 = ListNodeHelper.createList(5);
		ListNode l3 = ListNodeHelper.createList(3);
		List<ListNode> initial = new ArrayList<ListNode>();
		initial.add(l1);
		initial.add(l2);
		initial.add(l3);
		mergeKSortedLists(initial).stream().forEach(System.out::print);
	}

	static List<Integer> mergeKSortedLists(List<ListNode> initial) {
		if (initial.isEmpty())
			return null;
		List<Integer> result = new ArrayList<Integer>();
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {
				return Integer.compare(n1.getVal(), n2.getVal());
			}
		});

		for (ListNode n : initial) {
			minHeap.offer(n);
		}

		while (!minHeap.isEmpty()) {
			ListNode n = minHeap.poll();
			if (n.getNext() != null)
				minHeap.offer(n.getNext());
			result.add(n.getVal());
		}

		return result;
	}
}
