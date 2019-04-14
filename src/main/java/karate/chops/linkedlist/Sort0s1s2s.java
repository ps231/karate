package karate.chops.linkedlist;

import java.util.*;

public class Sort0s1s2s {

	public static void main(String[] args) {
		ListNodeHelper.printList(sortList(createList(8)));
	}

	private static ListNode createList(int size) {
		ListNode dummy = new ListNode();
		ListNode iter = dummy;
		for (int i = 0; i < size; i++) {
			iter.next = new ListNode(new Random().nextInt(2));
			iter = iter.next;
		}
		return dummy.next;
	}

//	private static ListNode sortList(ListNode n) {
//		if (n == null)
//			return n;
//
//		ListNode dummy0 = new ListNode(-1);
//		ListNode iter0 = dummy0;
//		ListNode dummy1 = new ListNode(-1);
//		ListNode iter1 = dummy1;
//		ListNode dummy2 = new ListNode(-1);
//		ListNode iter2 = dummy2;
//
//		while (n != null) {
//			if (n.val == 0) {
//				iter0.next = n;
//				iter0 = iter0.next;
//			} else if (n.val == 1) {
//				iter1.next = n;
//				iter1 = iter1.next;
//			} else if (n.val == 2) {
//				iter2.next = n;
//				iter2 = iter2.next;
//			} else {
//				throw new IllegalArgumentException("invalid input");
//			}
//			n = n.next;
//		}
//		iter0.next = null;
//		iter1.next = null;
//		iter2.next = null;
//
//		iter0.next = dummy1.next;
//		iter1.next = dummy2.next;
//
//		return dummy0.next;
//	}

	static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode zeroHead = null;
		ListNode zeroNext = null;
		ListNode oneHead = null;
		ListNode oneNext = null;
		ListNode twoHead = null;
		ListNode twoNext = null;
		while (head != null) {
			if (head.val == 0) {
				if (zeroHead == null) {
					zeroHead = head;
					zeroNext = zeroHead;
				} else {
					zeroNext.next = head;
					zeroNext = zeroNext.next;
				}
			} else if (head.val == 1) {
				if (oneHead == null) {
					oneHead = head;
					oneNext = oneHead;
				} else {
					oneNext.next = head;
					oneNext = oneNext.next;
				}
			} else if (head.val == 2) {
				if (twoHead == null) {
					twoHead = head;
					twoNext = twoHead;
				} else {
					twoNext.next = head;
					twoNext = twoNext.next;
				}
			}
			head = head.next;
		}

		if (zeroNext != null)
			zeroNext.next = null;
		if (oneNext != null)
			oneNext.next = null;
		if (twoNext != null)
			twoNext.next = null;

		if (zeroHead != null) {
			head = zeroHead;
			if (oneHead != null) {
				zeroNext.next = oneHead;
				oneNext.next = twoHead;
			} else if (twoHead != null) {
				zeroNext.next = twoHead;
			}
		} else if (oneHead != null) {
			head = oneHead;
			oneNext.next = twoHead;
		} else {
			head = twoHead;
		}
		return head;
	}
}
