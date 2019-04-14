package karate.chops.trees;

public class BTaBST {

	public static void main(String...strings ) {
		System.out.println(isBST(CreateBST.createBinarySearchTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(isBST(CreateBST.createAnotherBinaryTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(isBST(BinaryTree.createBalancedTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

//	private static boolean isBST(BinaryTreeNode n, int lowerBound, int upperBound) {
//		if(n==null) return true;
//		
//		if(n.value > upperBound || n.value < lowerBound) return false;
//		
//		return n.value < upperBound
//				&& n.value > lowerBound
//				&& isBST(n.left, lowerBound, n.value)
//				&& isBST(n.right, n.value, Math.max(n.value, upperBound));
//		
//	}

	private static boolean isBST(BinaryTreeNode root, int min, int max) {
		if(root==null)
			return true;
		
		boolean left = isBST(root.left,min, root.value);
		boolean right = isBST(root.right, root.value, max);
		
		return left&&right&&root.value>min&&root.value<max;
	}
}
