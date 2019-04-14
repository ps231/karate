package karate.chops.linkedlist;

public class EvenOddMerge {

	public static void main(String... strings) {
		ListNode head = ListNodeHelper.createList(5);
		ListNodeHelper.printList(head);
		ListNodeHelper.printList(evenOddMerge(head));

		head = ListNodeHelper.createList(4);
		ListNodeHelper.printList(head);
		ListNodeHelper.printList(evenOddMerge(head));

		head = ListNodeHelper.createList(3);
		head.next.val = 1;
		head.next.next.val = 1;
		ListNodeHelper.printList(head);
		ListNodeHelper.printList(evenOddMerge(head));

		head = ListNodeHelper.createList(3);
		head.val = 2;
		head.next.val = 2;
		head.next.next.val = 2;
		ListNodeHelper.printList(head);
		ListNodeHelper.printList(evenOddMerge(head));
	}

//	private static ListNode evenOddMerge(ListNode head) {
//		ListNode evenHead = head;
//		ListNode even = head;
//		ListNode oddHead = even.next;
//		ListNode odd = oddHead;
//		
//		if(oddHead == null || oddHead.next == null)	
//			return even;
//		
//		int i = 2;
//		head = head.next.next;
//		
//		while(head != null) {
//			if(i%2==0) {
//				even.next = head;
//				even = even.next;
//			} else {
//				odd.next = head;
//				odd = odd.next;
//			}
//			head = head.next;
//			i++;
//		}
//		
//		if(i%2 != 0) {
//			odd.next = null;
//		}
//		even.next = oddHead;
//		return evenHead;
//	}

//	private static ListNode evenOddMerge(ListNode root) {
//		if (root == null || root.next == null || root.next.next == null)
//			return root;
//
//		ListNode even = root;
//		ListNode odd = root.next;
//		ListNode oddHead = odd;
//		ListNode iter = odd.next;
//
//		int count = 2;
//		while (iter != null) {
//			if (count % 2 == 0) {
//				even.next = iter;
//				even = even.next;
//			} else {
//				odd.next = iter;
//				odd = odd.next;
//			}
//			count++;
//			iter = iter.next;
//		}
//
//		if (count % 2 != 0)
//			odd.next = null;
//		even.next = oddHead;
//		return root;
//	}

	private static ListNode evenOddMerge(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode odd = null, oddIter = null, even = null, evenIter = null;
		while (head != null) {
			if (head.val % 2 == 0) {
				if (even == null) {
					even = head;
					evenIter = even;
				} else {
					evenIter.next = head;
					evenIter = evenIter.next;
				}
			} else {
				if (odd == null) {
					odd = head;
					oddIter = odd;
				} else {
					oddIter.next = head;
					oddIter = oddIter.next;
				}
			}
			head = head.next;
		}
		if (even == null) {
			oddIter.next = null;
			return odd;
		}

		evenIter.next = odd;
		if (oddIter != null)
			oddIter.next = null;
		return even;
	}

}
