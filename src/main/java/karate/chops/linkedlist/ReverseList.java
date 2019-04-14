package karate.chops.linkedlist;

public class ReverseList {
	public static void main(String... strings) {
		ListNodeHelper.printList(reverseList(ListNodeHelper.createList(5)));
		ListNodeHelper.printList(reverseList(ListNodeHelper.createList(4)));
		ListNodeHelper.printList(reverseList(ListNodeHelper.createList(3)));
		ListNodeHelper.printList(reverseList(ListNodeHelper.createList(2)));
		ListNodeHelper.printList(reverseList(ListNodeHelper.createList(1)));
		ListNodeHelper.printList(reverseList(null));
	}

//	private static ListNode reverseList(ListNode head) {
//		if (head == null)
//			return null;
//
//		if (head.next == null)
//			return head;
//
//		ListNode prev = null, next = head.next;
//		while (next != null) {
//			head.next = prev;
//			prev = head;
//			head = next;
//			next = next.next;
//		}
//		if (head != null)
//			head.next = prev;
//		return head;
//	}

	private static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p1 = null;
		ListNode current = head;
		ListNode p2 = head.next;

		while (p2 != null) {
			current.next = p1;
			p1 = current;
			current = p2;
			p2 = p2.next;
		}
		current.next = p1;
		return current;

	}
}
