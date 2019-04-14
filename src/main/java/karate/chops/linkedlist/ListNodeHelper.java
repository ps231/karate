package karate.chops.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ListNodeHelper {

	public static ListNode createList(int size) {
		// TODO Auto-generated method stub
		ListNode dummy = new ListNode();
		ListNode iter = dummy;
		for (int i = 0; i < size; i++) {
			iter.next = new ListNode(i + 1);
			iter = iter.next;
		}
		return dummy.next;
	}

	public static void printList(ListNode head) {
		// TODO Auto-generated method stub
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}

	public static List<ListNode> createList(List<List<Integer>> sortedSublists) {
		List<ListNode> result = new ArrayList<ListNode>();

		for (List<Integer> sublist : sortedSublists) {
			ListNode dummy = new ListNode();
			ListNode iter = dummy;
			for (int elem : sublist) {
				iter.next = new ListNode(elem);
				iter = iter.next;
			}
			result.add(dummy.next);
		}
		return result;
	}

	public static ListNode createCircularLinkedList() {
		ListNode n = createList(5);
		n.next.next.next.next.next = n.next;
		return n;
	}
}
