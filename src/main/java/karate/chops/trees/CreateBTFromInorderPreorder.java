package karate.chops.trees;

import java.util.*;

public class CreateBTFromInorderPreorder {

	public static void main(String[] arsg) {
		List<String> inorder = Arrays.asList("F", "B", "A", "E", "H", "C", "D", "I", "G");
		List<String> preorder = Arrays.asList("H", "B", "F", "E", "A", "C", "D", "G", "I");
		BinaryTreeNode root = createFromInorderPostorder(inorder, preorder);
		BinaryTree.printTreeInorder(root);
	}

	private static BinaryTreeNode createFromInorderPostorder(List<String> inorder, List<String> preorder) {
		Map<String, Integer> inorderMap = new HashMap<String, Integer>();
		for (int i = 0; i < inorder.size(); i++)
			inorderMap.put(inorder.get(i), i);
		return helper(0, preorder.size() - 1, preorder, 0, inorder.size() - 1, inorderMap);
	}

	private static BinaryTreeNode helper(int preorderStart, int preorderEnd, List<String> preorder, int inorderStart,
			int inorderEnd, Map<String, Integer> inorderMap) {
		if (preorderEnd <= preorderStart || inorderEnd <= inorderStart)
			return null;
		int rootIndex = inorderMap.get(preorder.get(preorderStart));
		int leftTreeSize = rootIndex - inorderStart;

		BinaryTreeNode n = new BinaryTreeNode(preorder.get(preorderStart),
				helper(preorderStart + 1, preorderStart + 1 + leftTreeSize, preorder, inorderStart, rootIndex, inorderMap),
				helper(preorderStart + 1 + leftTreeSize, preorderEnd, preorder, rootIndex + 1, inorderEnd, inorderMap));

		return n;
	}
}