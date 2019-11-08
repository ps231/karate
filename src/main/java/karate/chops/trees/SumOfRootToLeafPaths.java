package karate.chops.trees;

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

    private static void helper(BinaryTreeNode root, int intermediateSum, Sum finalSum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            finalSum.sum += intermediateSum + root.value;
            return;
        }
        helper(root.left, intermediateSum + root.value, finalSum);
        helper(root.right, intermediateSum + root.value, finalSum);
    }

    private static class Sum {
        int sum;
    }
}
