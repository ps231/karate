package karate.chops.trees;

public class IsRootToLeafPathEqualToSum {
	public static void main(String[] args) {
		System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 7));
		System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 12));
		System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 6));
		System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 10));
	}

	private static boolean hasPathEqualsSum(BinaryTreeNode root, int sum) {
		Temp1 t = new Temp1();
		helper(root, sum, t);
		return t.hasPath;
	}

	private static void helper(BinaryTreeNode root, int sum, Temp1 t) {
		if (root == null || t.hasPath)
			return;

		sum = sum - root.value;

		helper(root.left, sum, t);
		helper(root.right, sum, t);

		if (root.left == null && root.right == null && sum == 0)
			t.hasPath = true;
	}
}

class Temp1 {
	boolean hasPath;
}