package karate.chops.trees;

import java.util.*;

public class FindRangeInBST {

	public static void main(String[] arsg) {
		findElementsInRange(CreateBST.createBinarySearchTree(), 7, 7).stream().forEach(System.out::println);
		findElementsInRange(CreateBST.createBinarySearchTree(), 1, 3).stream().forEach(System.out::println);
		findElementsInRange(CreateBST.createBinarySearchTree(), 1, 7).stream().forEach(System.out::println);
		findElementsInRange(CreateBST.createBinarySearchTree(), 7, 15).stream().forEach(System.out::println);
		findElementsInRange(CreateBST.createBinarySearchTree(), 15, 20).stream().forEach(System.out::println);
		findElementsInRange(CreateBST.createBinarySearchTree(), 20, 28).stream().forEach(System.out::println);
	}

	private static List<Integer> findElementsInRange(BinaryTreeNode root, int n1, int n2) {
		if (root == null)
			return null;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (!stack.isEmpty() || root != null) {
			if (root.value < n1) {
				root = root.right;
			} else if (root.value > n1) {
				stack.push(root);
				root = root.left;
			} else {
				break;
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		while (root != null || !stack.isEmpty()) {
			result.add(root.value);
			if (root.value == n2)
				break;
			if (root.right != null) {
				root = root.right;
				while (root.left != null) {
					stack.push(root);
					root = root.left;
				}
				result.add(root.value);
				if (root.value == n2)
					break;
				root = stack.pop();
			} else {
				if(stack.isEmpty())
					throw new IllegalArgumentException("element not found");
				root = stack.pop();
			}
		}

		return result;
	}

}
