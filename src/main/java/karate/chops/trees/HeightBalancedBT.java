package karate.chops.trees;

public class HeightBalancedBT {

	public static void main(String... strings) {
		System.out.println(isTreeHeightBalanced(BinaryTree.createLeftSkewedTree()).balanced);
		System.out.println(isTreeHeightBalanced(BinaryTree.createBalancedTree()).balanced);
	}

	private static BalanceStatusWithHeight isTreeHeightBalanced(BinaryTreeNode root) {
		if (root == null)
			return new BalanceStatusWithHeight(true, 0);

		BalanceStatusWithHeight left = isTreeHeightBalanced(root.left);
		BalanceStatusWithHeight right = isTreeHeightBalanced(root.right);

		if (left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1)
			return new BalanceStatusWithHeight(true, Math.max(left.height, right.height) + 1);

		return new BalanceStatusWithHeight(false, -1);
	}
}

class BalanceStatusWithHeight {
	boolean balanced;
	int height;

	BalanceStatusWithHeight(boolean b, int h) {
		balanced = b;
		height = h;
	}
}
