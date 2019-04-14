package karate.chops.trees;

public class IsSymmetricBT {

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTree.createBalancedSymmetricTree();
		System.out.println(isSymmetric(root));

		root.right.left = null;
		System.out.println(isSymmetric(root));
	}

	private static boolean isSymmetric(BinaryTreeNode root) {
		if (root == null)
			return true;

		return isSymmetric(root.left, root.right);
	}

//	private static boolean isSymmetric(BinaryTreeNode n1, BinaryTreeNode n2) {
//		if (n1 == null && n2 == null)
//			return true;
//
//		if ((n1 == null && n2 != null) || (n2 == null && n1 != null))
//			return false;
//
//		return n1.value == n2.value && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
//	}

	private static boolean isSymmetric(BinaryTreeNode n1, BinaryTreeNode n2) {
		if (n1 == null && n2 == null)
			return true;
		if (n1 == null || n2 == null || n1.value != n2.value)
			return false;

		return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
	}
}
