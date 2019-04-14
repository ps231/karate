package karate.chops.trees;

//public class SumOfRootToLeafPaths {
//	
//	public static void main(String[] args) {
//		System.out.println(sumRootToLeaf(BinaryTree.createPerfectBinaryTree()));
//	}
//	
//	private static int sumRootToLeaf(BinaryTreeNode n) {
//		Temp t = new Temp();
//		sumHelper(n, 0, t);
//		return t.sum;
//	}
//	
//	private static void sumHelper(BinaryTreeNode root, int partialSum, Temp t) {
//		if(root == null)
//			return;
//		
//		partialSum += root.value;
//		sumHelper(root.left, partialSum, t);
//		sumHelper(root.right, partialSum, t);
//		
//		if(root.left == null && root.right == null)
//			t.sum = t.sum + partialSum;
//	}
//
//}
//
//class Temp {
//	int sum;
//}

public class SumOfRootToLeafPaths {
	public static void main(String[] args) {
		sumOfRootToLeaf(BinaryTree.createPerfectBinaryTree());
		sumOfRootToLeaf(BinaryTree.createBalancedAsymmetricTree());
		sumOfRootToLeaf(BinaryTree.createLeftSkewedTree());
	}

	private static void sumOfRootToLeaf(BinaryTreeNode root) {
		Sum s = new Sum();
		helper(root, 0, s);
		System.out.println(s.sum);
	}

	private static void helper(BinaryTreeNode root, int pathSum, Sum s) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			pathSum += root.value;
			s.sum += pathSum;
			return;
		}

		helper(root.left, pathSum + root.value, s);
		helper(root.right, pathSum + root.value, s);
	}

	private static class Sum {
		int sum;
	}
}
