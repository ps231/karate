package karate.chops.trees;

//https://leetcode.com/problems/maximum-binary-tree/description/
public class CreateMaximumBT {

	public static void main(String... strings) {
		BinaryTreeNode root = constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
		BinaryTree.printTreeInorder(root);
	}

	public static BinaryTreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return helper(nums, 0, nums.length - 1);
	}

	private static BinaryTreeNode helper(int[] nums, int start, int end) {
		if (start > end || start < 0 || end >= nums.length)
			return null;

		int max = findMax(nums, start, end);
		BinaryTreeNode n = new BinaryTreeNode(nums[max], null, null);
		n.left = helper(nums, start, max - 1);
		n.right = helper(nums, max + 1, end);
		return n;
	}

	private static int findMax(int[] nums, int start, int end) {
		int maxIndex = Integer.MIN_VALUE;
		int currMax = Integer.MIN_VALUE;

		if (start == end)
			return start;

		for (int i = start + 1; i <= end; i++) {
			if (nums[i - 1] > nums[i] && nums[i - 1] > currMax) {
				currMax = nums[i - 1];
				maxIndex = i - 1;
			} else if (nums[i] > nums[i - 1] && nums[i] > currMax) {
				currMax = nums[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
