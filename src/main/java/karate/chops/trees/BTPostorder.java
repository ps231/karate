package karate.chops.trees;

public class BTPostorder {
	
	public static void main(String...strings) {
		BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
		postorder(root);
	}
	
	private static void postorder(BinaryTreeNode root) {
		if(root == null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.value);
	}
}
