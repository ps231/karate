package karate.chops.linkedlist;

public class RemoveDuplicatesFromSortedList {

	public static void main(String... strings) {
		ListNode head = ListNodeHelper.createList(7);
		head.next.val = 1;
		head.next.next.val = 3;
		head.next.next.next.val = 3;
		head.next.next.next.next.val = 4;
		head.next.next.next.next.next.val = 5;
		head.next.next.next.next.next.next.val = 5;
		ListNodeHelper.printList(head);
		head = removeDuplicates(head);
		ListNodeHelper.printList(head);

		ListNodeHelper.printList(removeDuplicates(ListNodeHelper.createList(5)));

		head = ListNodeHelper.createList(3);
		head.next.val = 1;
		head.next.next.val = 1;
		ListNodeHelper.printList(head);
		head = removeDuplicates(head);
		ListNodeHelper.printList(head);

	}
//	private static ListNode removeDuplicates(ListNode head) {
//		ListNode uniq = head;
//		ListNode dup = uniq.next;
//
//		while (dup != null) {
//			while (dup != null && dup.val == uniq.val)
//				dup = dup.next;
//
//			if (dup == null) {
//				uniq.next = null;
//			} else { 
//				uniq.next = dup;
//				uniq = uniq.next;
//				dup = dup.next;
//			}
//		}
//
//		return head;
//	}

//	private static ListNode removeDuplicates(ListNode head) {
//		if (head == null)
//			return null;
//		if (head.next == null)
//			return head;
//
//		ListNode n1 = head, n2 = head.next;
//		while (n2 != null) {
//			while (n2 != null && n1.val == n2.val) {
//				n2 = n2.next;
//
//			}
//			n1.next = n2;
//			n1 = n1.next;
//			if (n2 != null)
//				n2 = n2.next;
//		}
//		return head;
//	}
//	
	private static ListNode removeDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p1 = head, p2 = head.next;
		while (p2 != null) {
			while (p2 != null && p2.val == p1.val)
				p2 = p2.next;
			p1.next = p2;
			p1 = p2;
			if (p2 != null)
				p2 = p2.next;
		}
		return head;
	}
}
