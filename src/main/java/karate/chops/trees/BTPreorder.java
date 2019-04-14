package karate.chops.trees;

public class BTPreorder {
	
	public static void main(String...strings) {
		BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
		preorder(root);
	}
	
	private static void preorder(BinaryTreeNode root) {
		if(root == null)
			return;
		System.out.println(root.value);
		preorder(root.left);
		preorder(root.right);
	}

}
