package karate.chops.linkedlist;

public class CyclicRightShift {

	public static void main(String... strings) {
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 1));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 6));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 2));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 7));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 3));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 8));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 4));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 9));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 5));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 10));
		ListNodeHelper.printList(cyclicRightShift(ListNodeHelper.createList(5), 0));
	}

//	private static ListNode cyclicRightShift(ListNode head, int shift) {
//		// TODO Auto-generated method stub
//		
//		ListNode tail = head;
//		ListNode iter = head;
//		int count = 0;
//		while(iter!=null) {
//			iter = iter.next;
//			count++;
//		}
//		
//		if(count == shift)
//			return head;
//		
//		int actualShift = count > shift ? count - shift : shift % count;
//		iter = head;
//		
//		for(int i = 1; i < actualShift; i++) {
//			iter = iter.next;
//			tail = tail.next;
//			count++;
//		}
//		
//		while(tail.next != null) {
//			tail = tail.next;
//			count++;
//		}
//			
//		tail.next = head;
//		head = iter.next;
//		iter.next = null;
//		
//		return head;
//	}

	private static ListNode cyclicRightShift(ListNode root, int k) {
		if (root == null || root.next == null || k == 0)
			return root;

		int len = 1;
		ListNode iter = root;
		while (iter.next != null) {
			iter = iter.next;
			len++;
		}
		iter.next = root;

		int newLast = len - (k % len);
		len = 1;
		iter = root;
		while (len < newLast) {
			iter = iter.next;
			len++;
		}
		root = iter.next;
		iter.next = null;
		return root;
	}

}
