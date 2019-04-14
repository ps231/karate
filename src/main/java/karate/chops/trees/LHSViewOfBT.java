package karate.chops.trees;

import java.util.*;

public class LHSViewOfBT {
	public static void main(String[] args) {
		System.out.println("LHS View");
		printLHSViewOfBT(BinaryTree.createPerfectBinaryTree(), true);
		System.out.println("RHS View");
		printLHSViewOfBT(BinaryTree.createPerfectBinaryTree(), false);
		System.out.println("LHS View");
		printLHSViewOfBT(BinaryTree.createBalancedAsymmetricTree(), true);
		System.out.println("RHS View");
		printLHSViewOfBT(BinaryTree.createBalancedAsymmetricTree(), false);
		printLHSViewOfBT(createCustomBinaryTree(), true);
		printLHSViewOfBT(createCustomBinaryTree(), false);
	}

	private static BinaryTreeNode createCustomBinaryTree() {
		BinaryTreeNode root = new BinaryTreeNode(1, null, null);
		root.left = new BinaryTreeNode(2, null, null);
		root.right = new BinaryTreeNode(3,null,null);
		root.left.right=new BinaryTreeNode(4,null,null);
		root.right.left = new BinaryTreeNode(5,null,null);
		root.right.left.left = new BinaryTreeNode(6,null,null);
		return root;
	}

	private static void printLHSViewOfBT(BinaryTreeNode n, boolean isLHS) {
		if (n == null)
			return;

		Map<Integer, List<BinaryTreeNode>> map = new LinkedHashMap<Integer, List<BinaryTreeNode>>();
		helper(n, map, 0, isLHS);

		for (Map.Entry<Integer, List<BinaryTreeNode>> entry : map.entrySet()) {
			System.out.println("level: " + entry.getKey() + ", node: " + entry.getValue().get(0).value);
		}
	}

	private static void helper(BinaryTreeNode n, Map<Integer, List<BinaryTreeNode>> map, int level, boolean isLHS) {
		if (n == null)
			return;

		if (!map.containsKey(level))
			map.put(level, new ArrayList<BinaryTreeNode>());
		map.get(level).add(n);

		if (isLHS) {
			helper(n.left, map, level + 1, isLHS);
			helper(n.right, map, level + 1, isLHS);
		} else {
			helper(n.right, map, level + 1, isLHS);
			helper(n.left, map, level + 1, isLHS);
		}
	}
}
