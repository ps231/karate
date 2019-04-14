package karate.chops.trees;

import java.util.*;

public class NextRHSNodeInABT {
	public static void main(String[] arsg) {
		printRHS(getRight(BinaryTree.createPerfectBinaryTree(), 1));
		printRHS(getRight(BinaryTree.createPerfectBinaryTree(), 5));
		printRHS(getRight(BinaryTree.createPerfectBinaryTree(), 4));
		printRHS(getRight(BinaryTree.createPerfectBinaryTree(), 7));
		printRHS(getRight(BinaryTree.createPerfectBinaryTree(), 8));
	}

	private static void printRHS(BinaryTreeNode rhs) {
		if (rhs == null)
			System.out.println("No rhs node");
		else
			System.out.println(rhs.value);
	}

	private static BinaryTreeNode getRight(BinaryTreeNode root, int key) {
		if (root == null)
			return null;
		Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> q2 = new LinkedList<BinaryTreeNode>();
		q1.offer(root);

		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				BinaryTreeNode n = q1.poll();
				if (n.value == key) {
					if (!q1.isEmpty())
						return q1.poll();
					else
						return null;
				} else {
					if (n.left != null)
						q2.offer(n.left);
					if (n.right != null)
						q2.offer(n.right);
				}
			}
			while (!q2.isEmpty()) {
				BinaryTreeNode n = q2.poll();
				if (n.value == key) {
					if (!q2.isEmpty())
						return q2.poll();
					else
						return null;
				} else {
					if (n.left != null)
						q1.offer(n.left);
					if (n.right != null)
						q1.offer(n.right);
				}
			}
		}
		return null;
	}
}
