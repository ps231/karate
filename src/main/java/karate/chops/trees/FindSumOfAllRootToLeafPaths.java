package karate.chops.trees;

public class FindSumOfAllRootToLeafPaths {
    public static void main(String[] args) {
        System.out.println(findSumOfAllRootToLeafPaths(BinaryTree.createPerfectBinaryTree()));
        System.out.println(findSumOfAllRootToLeafPaths(BinaryTree.createLeftSkewedTree()));
    }

    private static int findSumOfAllRootToLeafPaths(BinaryTreeNode root) {
        int[] sum = new int[1];
        helper(root, sum, "");
        return sum[0];
    }

    private static void helper(BinaryTreeNode root, int[] sum, String intermediate) {
        if (root == null)
            return;
        helper(root.left, sum, intermediate + root.value);
        helper(root.right, sum, intermediate + root.value);
        if (root.left == null && root.right == null)
            sum[0] += Integer.parseInt(intermediate + root.value);

    }
}
