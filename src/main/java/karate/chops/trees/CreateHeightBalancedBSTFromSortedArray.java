package karate.chops.trees;

public class CreateHeightBalancedBSTFromSortedArray {

	public static void main(String[] args) {
		BinaryTree.printTreeInorder(create(new int[] { 8, 10, 15, 23, 32, 48, 65 }));
		System.out.println("");
		BinaryTree.printTreeInorder(create(new int[] { 5, 8, 10, 15, 23, 32, 48, 65 }));
	}

	private static BinaryTreeNode create(int[] A) {
		return helper(A, 0, A.length - 1);
	}

	private static BinaryTreeNode helper(int[] A, int low, int high) {
		if (low > high)
			return null;
		int mid = low + (high - low) / 2;
		BinaryTreeNode n = new BinaryTreeNode(A[mid], helper(A, low, mid - 1), helper(A, mid + 1, high));
		return n;
	}
}
