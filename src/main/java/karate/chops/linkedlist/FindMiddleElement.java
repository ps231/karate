package karate.chops.linkedlist;

public class FindMiddleElement {

	public static void main(String[] args) {
		System.out.println(findMid(ListNodeHelper.createList(1)).getVal());
		System.out.println(findMid(ListNodeHelper.createList(2)).getVal());
		System.out.println(findMid(ListNodeHelper.createList(3)).getVal());
		System.out.println(findMid(ListNodeHelper.createList(4)).getVal());
		System.out.println(findMid(ListNodeHelper.createList(5)).getVal());
	}

	private static ListNode findMid(ListNode n) {
		if (n == null)
			return null;
		if (n.next == null)
			return n;
		if (n.next.next == null)
			return n.next;
		ListNode fast = n.next.next, slow = n;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.next;
	}

}
