package karate.chops.trees;

public class BTMirrorImageOfAnotherBT {

	public static void main(String[] args) {
		BinaryTreeNode n1 = createBinaryTree();
		BinaryTreeNode n2 = createMirror();
		System.out.println(isBTAMirrorOfAnotherBT(n1, n2));
	}

	private static boolean isBTAMirrorOfAnotherBT(BinaryTreeNode n1, BinaryTreeNode n2) {
		if (n1 == null && n2 == null)
			return true;
		if (n1 == null || n2 == null)
			return false;
		return n1.value == n2.value 
				&& isBTAMirrorOfAnotherBT(n1.left, n2.right)
				&& isBTAMirrorOfAnotherBT(n1.right, n2.left);
	}

	private static BinaryTreeNode createBinaryTree() {
		BinaryTreeNode root = new BinaryTreeNode(1, null, null);
		root.left = new BinaryTreeNode(2, null, null);
		root.right = new BinaryTreeNode(3, null, null);
		root.left.left = new BinaryTreeNode(4, null, null);
		root.left.right = new BinaryTreeNode(5, null, null);
		return root;
	}

	private static BinaryTreeNode createMirror() {
		BinaryTreeNode root = new BinaryTreeNode(1, null, null);
		root.left = new BinaryTreeNode(3, null, null);
		root.right = new BinaryTreeNode(2, null, null);
		root.right.left = new BinaryTreeNode(5, null, null);
		root.right.right = new BinaryTreeNode(4, null, null);
		root.right.right.right = new BinaryTreeNode(6, null, null);
		return root;
	}
}
