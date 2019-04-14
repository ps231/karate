package karate.chops.linkedlist;

public class ReverseASublist {
	public static void main(String... strings) {
		ListNodeHelper.printList(reverseSublist(ListNodeHelper.createList(4), 2, 3));
		ListNodeHelper.printList(reverseSublist(ListNodeHelper.createList(5), 2, 4));
		ListNodeHelper.printList(reverseSublist(ListNodeHelper.createList(6), 3, 5));
//		ListNodeHelper.printList(reverseSublist(ListNodeHelper.createList(4), 1, 3));
		ListNodeHelper.printList(reverseSublist(ListNodeHelper.createList(4), 2, 4));
	}

	private static ListNode reverseSublist(ListNode head, int start, int end) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		if (start == end)
			return head;
		if (start > end)
			throw new IllegalArgumentException("illegal start end");
		
		ListNode prev = null, next = head.next, dummy = head;
		int count = 1;
		while (count != start && next != null) {
			prev = head;
			head = next;
			next = next.next;
			count++;
		}
		ListNode p1 = prev;
		while (count <= end && next != null) {
			head.next = prev;
			prev = head;
			head = next;
			next = next.next;
			count++;
		}
		if (count <= end) {
			head.next = prev;
			prev = head;
			head = next;
		}
		p1.next.next = head;
		p1.next = prev;

		return dummy;
	}

}
