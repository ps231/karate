package karate.chops.linkedlist;

import java.util.*;

public class IsSLLAPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome(ListNodeHelper.createList(5)));
		System.out.println(isPalindrome(getPalindromeList()));
		System.out.println(isPalindrome(getAnotherPalindromeList()));
		System.out.println(isPalindrome(ListNodeHelper.createList(4)));
		System.out.println(isPalindrome(ListNodeHelper.createList(3)));
		System.out.println(isPalindrome(ListNodeHelper.createList(2)));
		System.out.println(isPalindrome(ListNodeHelper.createList(1)));
		System.out.println(isPalindrome(null));
	}

	private static ListNode getPalindromeList() {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(5);
		root.next.next.next = new ListNode(2);
		root.next.next.next.next = new ListNode(1);
		return root;
	}

	private static ListNode getAnotherPalindromeList() {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(1);
//		root.next.next.next.next = new ListNode(1);
		return root;
	}

//	private static boolean isPalindrome(ListNode root) {
//		if (root == null)
//			throw new IllegalArgumentException("input list is null");
//
//		Stack<ListNode> stack = new Stack<ListNode>();
//		ListNode iter = root;
//		while (iter != null) {
//			stack.push(iter);
//			iter = iter.next;
//		}
//
//		while (root != null) {
//			if (root.val != stack.pop().val)
//				return false;
//			root = root.next;
//		}
//
//		return stack.isEmpty();
//	}

	private static boolean isPalindrome(ListNode head) {

		if (head == null)
			return false;
		if (head.next == null)
			return true;

		ListNode revHead = null;
		int len = findLen(head);
		if (len % 2 == 0)
			revHead = reverseList(len / 2, head);
		else
			revHead = reverseList((len / 2) + 1, head);
		while (head != null && revHead != null) {
			if (head.val != revHead.val)
				return false;
			head = head.next;
			revHead = revHead.next;
		}
		return true;
	}

	private static int findLen(ListNode head) {
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}

	private static ListNode reverseList(int startIndex, ListNode head) {

		ListNode prev = null;
		ListNode current = head;

		while (startIndex != 0) {
			startIndex--;
			current = current.next;
		}

		ListNode next = current.next;
		while (next != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
		}
		current.next = prev;
		return current;
	}
}
