package karate.chops.trees;

public class LCAInBST {
	
	public static void main(String...strings ) {
		LCAInBST b  = new LCAInBST();
		BinaryTreeNode lca = b.findBSTLca(CreateBST.createBinarySearchTree(), 25, 28);
		System.out.println(lca.value);
	}
	
	private BinaryTreeNode findBSTLca(BinaryTreeNode root, int n1, int n2) {
		while(root != null) {
			if(root.value < n1 && root.value < n2)
				root = root.right;
			else if (root.value > n1 && root.value>n2)
				root = root.left;
			else
				return root;
		}
		return null;
	}

}
