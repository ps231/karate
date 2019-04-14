package karate.chops.linkedlist;
import java.util.*;
public class Temp {
//	public static void main(String[] args) {
//		ListNodeHelper.printList(mergeLists(ListNodeHelper.createList(3), ListNodeHelper.createList(5)));
//		ListNodeHelper.printList(mergeLists(ListNodeHelper.createList(3), ListNodeHelper.createList(1)));
//		ListNodeHelper.printList(mergeLists(ListNodeHelper.createList(3), ListNodeHelper.createList(3)));
//		ListNodeHelper.printList(mergeLists(null, ListNodeHelper.createList(5)));
//		ListNodeHelper.printList(mergeLists(ListNodeHelper.createList(3), null));
//		ListNodeHelper.printList(mergeLists(null, null));
//	}
//
//	private static ListNode mergeLists(ListNode n1, ListNode n2) {
//		if (n1 == null && n2 == null)
//			return null;
//		if (n1 == null)
//			return n2;
//		if (n2 == null)
//			return n1;
//
//		ListNode dummy = new ListNode(-1);
//		ListNode dummyIter = dummy;
//
//		while (n1 != null && n2 != null) {
//			if (n1.val > n2.val) {
//				dummyIter.next = n2;
//				n2 = n2.next;
//				dummyIter = dummyIter.next;
//			} else if (n1.val <= n2.val) {
//				dummyIter.next = n1;
//				n1 = n1.next;
//				dummyIter = dummyIter.next;
//			}
//		}
//
//		if (n1 == null)
//			dummyIter.next = n2;
//		else
//			dummyIter.next = n1;
//
//		return dummy.next;
//	}

//	public static void main(String[] args) {
//		ListNodeHelper.printList(reverseSubList(ListNodeHelper.createList(5), 2, 3));
//		ListNodeHelper.printList(reverseSubList(ListNodeHelper.createList(5), 2, 4));
//		ListNodeHelper.printList(reverseSubList(ListNodeHelper.createList(5), 3, 5));
////		ListNodeHelper.printList(reverseSubList(ListNodeHelper.createList(5), 1, 5));
//		ListNodeHelper.printList(reverseSubList(ListNodeHelper.createList(5), 6, 7));
//	}
//
//	private static ListNode reverseSubList(ListNode n, int start, int end) {
//
//		if (n == null || start == end)
//			return n;
//		if (start > end)
//			return null;
//
//		ListNode dummy = n;
//		int count = 1;
//
//		while (start - count != 1 && n != null) {
//			n = n.next;
//			count++;
//		}
//
//		if (n == null || n.next == null || n.next.next == null)
//			return null;
//		ListNode subListPrev = n;
//		ListNode prev = n.next;
//		ListNode current = n.next.next;
//		ListNode next = n.next.next.next;
//		while (end - count != 1) {
//			current.next = prev;
//			prev = current;
//			current = next;
//			if (next != null)
//				next = next.next;
//			count++;
//		}
//		subListPrev.next.next = current;
//		subListPrev.next = prev;
//		return dummy;
//	}

//	public static void main(String[] arsg) {
//		printDetails(getFirstNodeInCycle(ListNodeHelper.createCircularLinkedList()));
//		printDetails(getFirstNodeInCycle(ListNodeHelper.createList(5)));
//	}
//
//	private static void printDetails(ListNode cyclicNode) {
//		if (cyclicNode == null)
//			System.out.println("Cycle not detected");
//		else
//			System.out.println("First node in cycle is: " + cyclicNode.val);
//	}
//
//	private static ListNode getFirstNodeInCycle(ListNode n) {
//		if (n == null || n.next == null || n.next.next == null)
//			return null;
//
//		ListNode slow = n;
//		ListNode fast = n.next.next;
//		boolean cycleDetected = false;
//		while (fast != null && fast.next != null) {
//			if (slow == fast) {
//				cycleDetected = true;
//				break;
//			}
//			slow = slow.next;
//			fast = fast.next.next;
//		}
//
//		if (cycleDetected) {
//
//			int count = 1;
//			fast = slow.next;
//			while (fast != slow) {
//				count++;
//				fast = fast.next;
//			}
//
//			int i = 0;
//			slow = n;
//			fast = n;
//			while (i < count) {
//				fast = fast.next;
//				i++;
//			}
//
//			while (slow != fast) {
//				slow = slow.next;
//				fast = fast.next;
//			}
//			return slow;
//		} else {
//			return null;
//		}
//	}
	
	public static void main(String[] arsgs) {
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 0));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 1));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 2));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 3));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 4));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 5));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 6));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 7));
	}
	
	private static ListNode cyclicRightShift(ListNode n, int shift) {
		if(n==null || shift==0)
			return n;

		int len = 0;
		ListNode iter = n;
		while(iter!=null){
			iter = iter.next;
			len++;
		}

		int cyclicShift = shift % len;
		len=0;
		iter=n;
		for(int i=1;i<cyclicShift-1;i++){
			iter = iter.next;
		}
		ListNode newHead = iter.next;
		iter.next=null;
		iter=newHead;
		while(iter.next!=null)
			iter=iter.next;
		iter.next=n;
		return newHead;	
	}
}
