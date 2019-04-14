package karate.chops.trees;

import java.util.*;

public class BSTIterator {

	BinaryTreeNode next;
	Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

	BSTIterator(BinaryTreeNode root) {
		next = root;
		while (next.left != null) {
			stack.push(next);
			next = next.left;
		}
	}

	public boolean hasNext() {
		return next != null || !stack.isEmpty();
	}

	public BinaryTreeNode getNext() {

		BinaryTreeNode current = next;
		if (next.right != null) {
			next = next.right;
			while (next.left != null) {
				stack.push(next);
				next = next.left;
			}
		} else {
			if (stack.isEmpty())
				next = null;
			else
				next = stack.pop();
		}

		return current;
	}

	public static void main(String[] args) {
		BSTIterator iter = new BSTIterator(CreateBST.createBinarySearchTree());
		while (iter.hasNext()) {
			System.out.println(iter.getNext().value);
		}
	}
}
