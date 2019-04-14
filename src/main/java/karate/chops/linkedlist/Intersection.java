package karate.chops.linkedlist;

public class Intersection {
	public static void main(String... strings) {
		Intersection i = new Intersection();

		ListNode n1 = createList(5);
		ListNode n2 = new ListNode(10);
		n2.next = new ListNode(20);
		n2.next.next = n1.next.next.next.next;

		ListNode intersectionNode = i.intersect(n1, n2);
		
		if(intersectionNode == null)
			System.out.println("node not found");
		else
			System.out.println(intersectionNode.val);

	}

	private ListNode intersect(ListNode n1, ListNode n2) {
		// TODO Auto-generated method stub

		ListNode n1iter = n1;
		ListNode n2iter = n2;

		int l1 = findLen(n1iter);
		int l2 = findLen(n2iter);

		n1iter = n1;
		n2iter = n2;

		if (l1 < l2) {
			for (int i = 0; i < l2 - l1; i++)
				n2iter = n2iter.next;
		} else if (l1 > l2) {
			for (int i = 0; i < l1 - l2; i++)
				n1iter = n1iter.next;
		}

		while (n1iter != null && n2iter != null) {
			if (n1iter == n2iter)
				return n1iter;
			n1iter = n1iter.next;
			n2iter = n2iter.next;
		}

		return null;
	}

	int findLen(ListNode iter) {
		int count = 0;

		while (iter != null) {
			iter = iter.next;
			count++;
		}
		return count;
	}

	private static ListNode createList(int size) {
		// TODO Auto-generated method stub
		ListNode dummy = new ListNode();
		ListNode iter = dummy;
		for (int i = 0; i < size; i++) {
			iter.next = new ListNode(i + 1);
			iter = iter.next;
		}
		return dummy.next;
	}
}
