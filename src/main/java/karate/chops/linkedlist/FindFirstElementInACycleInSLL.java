package karate.chops.linkedlist;

public class FindFirstElementInACycleInSLL {
	public static void main(String[] args) {
		printResult(findFirstNodeInACycle(null));
		printResult(findFirstNodeInACycle(ListNodeHelper.createList(1)));
		printResult(findFirstNodeInACycle(ListNodeHelper.createList(2)));
		printResult(findFirstNodeInACycle(ListNodeHelper.createList(3)));
		printResult(findFirstNodeInACycle(ListNodeHelper.createList(5)));
		printResult(findFirstNodeInACycle(ListNodeHelper.createCircularLinkedList()));
	}

	private static void printResult(ListNode n) {
		if (n == null)
			System.out.println("No cycle detected");
		else
			System.out.println("Cycle detected, first node in the cycle is : " + n.val);
	}

	private static ListNode findFirstNodeInACycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		if (head.next == head)
			return head;

		ListNode slow = head;
		ListNode fast = head.next.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				int cycleLength = 0;
				do {
					cycleLength++;
					fast = fast.next;
				} while (fast != slow);
				slow = head;
				fast = head;
				while (cycleLength != 0) {
					fast = fast.next;
					cycleLength--;
				}
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}
