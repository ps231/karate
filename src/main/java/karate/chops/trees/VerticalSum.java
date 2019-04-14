package karate.chops.trees;

import java.util.*;

public class VerticalSum {
	public static void main(String[] args) {
		Map<Integer, Integer> m = verticalSum(BinaryTree.createPerfectBinaryTree());
		for (Map.Entry<Integer, Integer> e : m.entrySet())
			System.out.println("line: " + e.getKey() + ", sum: " + e.getValue());
	}

	private static Map<Integer, Integer> verticalSum(BinaryTreeNode n) {
		Map<Integer, Integer> verticalSum = new HashMap<Integer, Integer>();
		helper(n, verticalSum, 0);
		return verticalSum;
	}

	private static void helper(BinaryTreeNode n, Map<Integer, Integer> m, int line) {
		if (n == null)
			return;

		if (m.containsKey(line)) {
			m.put(line, m.get(line) + n.value);
		} else {
			m.put(line, n.value);
		}
		helper(n.left, m, line - 1);
		helper(n.right, m, line + 1);
	}
}
