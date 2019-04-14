package karate.chops.trees;

import java.util.*;

public class FindAllRootToLeafPathsEqualsSum {

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
		root.left.left.value = 7;
		List<List<Integer>> paths = pathSum(root, 10);
		for (List<Integer> path : paths) {
			for (Integer i : path)
				System.out.print(i + " ");
			System.out.println("");
		}
	}

	private static List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {

		if (root == null)
			return null;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> intermediate = new ArrayList<Integer>();
		helper(result, intermediate, root, sum, 0);
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> intermediate, BinaryTreeNode root, int sum, int partialSum) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			if (root.value + partialSum == sum) {
				intermediate.add(root.value);
				result.add(new ArrayList<Integer>(intermediate));
				intermediate.remove(intermediate.size() - 1);
				return;
			} else {
				return;
			}
		}

		partialSum += root.value;
		intermediate.add(root.value);
		helper(result, intermediate, root.left, sum, partialSum);
		helper(result, intermediate, root.right, sum, partialSum);
		intermediate.remove(intermediate.size() - 1);
	}

}
