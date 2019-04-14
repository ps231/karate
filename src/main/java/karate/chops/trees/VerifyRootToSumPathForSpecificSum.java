package karate.chops.trees;

public class VerifyRootToSumPathForSpecificSum {

//	public static void main(String...strings ) {
//		int[] path = new int[5];
//		printPathThatHasTheExactSum(BinaryTree.createPerfectBinaryTree(),path,0,80);
//		printPathThatHasTheExactSum(BinaryTree.createPerfectBinaryTree(),path,0,7);
//		printPathThatHasTheExactSum(BinaryTree.createPerfectBinaryTree(),path,0,10);
//	}
//
//	private static void printPathThatHasTheExactSum(BinaryTreeNode n, int[] path, int i, int sum) {
//		// TODO Auto-generated method stub
//		if(n==null) return;
//		path[i++]=n.value;
//		sum = sum - n.value;
//		printPathThatHasTheExactSum(n.left, path,i,sum);
//		printPathThatHasTheExactSum(n.right, path,i,sum);
//		
//		if(n.left == null && n.right == null && sum == 0)
//			for(int j = 0; j<i;j++)
//				System.out.println(path[j]);
//	}

	public static void main(String[] args) {
		printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 10);
		printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 11);
		printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 6);
	}

	private static void printPathThatHasExactSum(BinaryTreeNode root, int remainingSum) {
		helper(root, remainingSum, "");
	}

	private static void helper(BinaryTreeNode root, int remainingSum, String intermediatePath) {
		if (root == null)
			return;

		if (root.left == null && root.right == null && root.value == remainingSum) {
			System.out.println(intermediatePath + " " + root.value);
			return;
		}

		helper(root.left, remainingSum - root.value, intermediatePath + " " + root.value);
		helper(root.right, remainingSum - root.value, intermediatePath + " " + root.value);
	}
}
