package karate.chops.trees;

import java.util.*;

//given two binary trees, check if the levels are anagrams of each other
public class BTAnagramLevels {

	public static void main(String[] args) {
		BinaryTreeNode n1 = createBinaryTree1();
		BinaryTreeNode n2 = createBinaryTree2();
		System.out.println(areLevelsAnagram(n1, n2));
	}

	private static BinaryTreeNode createBinaryTree1() {
		BinaryTreeNode root = new BinaryTreeNode();
		root.value = 1;

		BinaryTreeNode left = new BinaryTreeNode();
		left.value = 2;

		BinaryTreeNode right = new BinaryTreeNode();
		right.value = 3;

		root.left = left;
		root.right = right;

		left = new BinaryTreeNode();
		left.value = 4;

		right = new BinaryTreeNode();
		right.value = 5;

		root.left.left = left;
		root.left.right = right;

		left = new BinaryTreeNode();
		left.value = 6;

		right = new BinaryTreeNode();
		right.value = 7;

		root.right.left = left;
		root.right.right = right;

		return root;
	}

	private static BinaryTreeNode createBinaryTree2() {
		BinaryTreeNode root = new BinaryTreeNode();
		root.value = 1;

		BinaryTreeNode left = new BinaryTreeNode();
		left.value = 3;

		BinaryTreeNode right = new BinaryTreeNode();
		right.value = 2;

		root.left = left;
		root.right = right;

		left = new BinaryTreeNode();
		left.value = 6;

		right = new BinaryTreeNode();
		right.value = 5;

		root.left.left = left;
		root.left.right = right;

		left = new BinaryTreeNode();
		left.value = 4;

		right = new BinaryTreeNode();
		right.value = 7;

		root.right.left = left;
//        root.right.right = right;

		return root;
	}

	private static boolean areLevelsAnagram(BinaryTreeNode n1, BinaryTreeNode n2) {

		if (n1 == null || n2 == null)
			return false;

		if (n2 == null)
			return false;

		Set<BinaryTreeNode> s1 = new LinkedHashSet<BinaryTreeNode>();
		Set<BinaryTreeNode> s11 = new LinkedHashSet<BinaryTreeNode>();

		Set<BinaryTreeNode> s2 = new LinkedHashSet<BinaryTreeNode>();
		Set<BinaryTreeNode> s22 = new LinkedHashSet<BinaryTreeNode>();

		s1.add(n1);
		s2.add(n2);

		while (!s1.isEmpty() || !s11.isEmpty() || !s2.isEmpty() || !s22.isEmpty()) {
			if (!s1.isEmpty()) {
				while (s1.iterator().hasNext()) {
					BinaryTreeNode temp = s1.iterator().next();
					if (!s2.contains(temp)) {
						return false;
					} else {
						if (temp.left != null)
							s11.add(temp.left);
						if (temp.right != null)
							s11.add(temp.right);
						s1.remove(temp);
					}
				}
			} else {
				while (s11.iterator().hasNext()) {
					BinaryTreeNode temp = s11.iterator().next();
					if (!s22.contains(temp)) {
						return false;
					} else {
						if (temp.left != null)
							s1.add(temp.left);
						if (temp.right != null)
							s1.add(temp.right);
						s11.remove(temp);
					}
				}
			}

			if (!s2.isEmpty()) {
				while (s2.iterator().hasNext()) {
					BinaryTreeNode temp = s2.iterator().next();
					if (temp.left != null)
						s22.add(temp.left);
					if (temp.right != null)
						s22.add(temp.right);
					s2.remove(temp);
				}
			} else {
				while (s22.iterator().hasNext()) {
					BinaryTreeNode temp = s22.iterator().next();
					if (temp.left != null)
						s2.add(temp.left);
					if (temp.right != null)
						s2.add(temp.right);
					s22.remove(temp);
				}
			}
		}
		return true;
	}
}
