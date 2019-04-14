package karate.chops.trees;

public class CreateMirrorBT {

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
		BinaryTreeNode mirror = createMirror(root);

		BinaryTree.printTreeInorder(root);
		System.out.println("");
		BinaryTree.printTreeInorder(mirror);
	}

//	private static BinaryTreeNode createMirror(BinaryTreeNode n) {
//		if (n == null)
//			return null;
//
//		BinaryTreeNode mirror = new BinaryTreeNode(n.value, null, null);
//		mirror.right = createMirror(n.left);
//		mirror.left = createMirror(n.right);
//		return mirror;
//
//	}

	private static BinaryTreeNode createMirror(BinaryTreeNode root) {
		if (root == null)
			return null;
		return new BinaryTreeNode(root.value, createMirror(root.right), createMirror(root.left));
	}
}