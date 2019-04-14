package karate.chops.linkedlist;

public class MergeSortedLists {
	public static void main(String... str) {
		ListNode l1 = ListNodeHelper.createList(5);
		ListNode l2 = ListNodeHelper.createList(3);

		ListNode merged = mergeSortedLists(l1, l2);
		ListNodeHelper.printList(merged);
	}

	private static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode iter = result;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				iter.next = l1;
				l1 = l1.next;
				iter = iter.next;
			} else if (l2.val < l1.val) {
				iter.next = l2;
				l2 = l2.next;
				iter = iter.next;
			}
		}
		if (l1 == null)
			iter.next = l2;
		else
			iter.next = l1;

		return result.next;
	}

	
}
