package karate.chops.linkedlist;

public class RemoveKthElement {

	public static void main(String... strings) {
		ListNodeHelper.printList(removeKthElem(ListNodeHelper.createList(5), 1));
		ListNodeHelper.printList(removeKthElem(ListNodeHelper.createList(5), 2));
		ListNodeHelper.printList(removeKthElem(ListNodeHelper.createList(5), 3));
		ListNodeHelper.printList(removeKthElem(ListNodeHelper.createList(5), 4));
		ListNodeHelper.printList(removeKthElem(ListNodeHelper.createList(5), 5));
		ListNodeHelper.printList(removeKthElem(ListNodeHelper.createList(5), 6));
	}

//	private static ListNode removeKthElem(ListNode head, int k) {
//		if (head == null)
//			return null;
//		int count = 0;
//		ListNode p1 = head, p2 = head;
//		while (count < k && p2 != null) {
//			p2 = p2.next;
//			count++;
//		}
//		if (count == k && p2 == null)
//			return head.next;
//		if (count < k && p2 == null)
//			throw new IllegalArgumentException("k is greater than the list length");
//
//		while (p2.next != null) {
//			p1 = p1.next;
//			p2 = p2.next;
//		}
//		p1.next = p1.next.next;
//		return head;
//	}

//	private static ListNode removeKthElem(ListNode head, int k) {
//		if (head == null || k == 0)
//			return head;
//
//		int len = 0;
//		ListNode iter = head;
//		while (iter != null) {
//			len++;
//			iter = iter.next;
//		}
//
//		if (k > len)
//			throw new IllegalArgumentException("k is greater than linked list length");
//
//		if (k == len)
//			return head.next;
//
//		iter = head;
//		ListNode slow = head;
//		int count = 0;
//		while (count != k) {
//			count++;
//			iter = iter.next;
//		}
//		while (iter.next != null) {
//			slow = slow.next;
//			iter = iter.next;
//		}
//		slow.next = slow.next.next;
//		return head;
//
//	}

	private static ListNode removeKthElem(ListNode head, int k) {
		if (head == null)
			return null;

		int len = getLength(head);
		if (k > len)
			throw new IllegalArgumentException("invalid k");
		if (k == len)
			return head.next;
		ListNode p1 = head, p2 = head;
		while (k != 0) {
			p1 = p1.next;
			k--;
		}
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = p2.next.next;
		return head;
	}

	private static int getLength(ListNode n) {
		int length = 0;
		while (n != null) {
			length++;
			n = n.next;
		}
		return length;
	}

}
