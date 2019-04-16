package karate.chops.trees;

public class PrintRootToSumPathsForSpecificSum {
    public static void main(String[] args) {
        printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 10);
        printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 11);
        printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 6);
    }

    private static void printPathThatHasExactSum(BinaryTreeNode n, int sum) {
        helper(n, sum, "");
    }

    private static void helper(BinaryTreeNode n, int sum, String intermediate) {
        if (n == null)
            return;
        if (n.left == null && n.right == null && n.value == sum)
            System.out.println(intermediate + " " + n.value);
        helper(n.left, sum - n.value, intermediate + " " + n.value);
        helper(n.right, sum - n.value, intermediate + " " + n.value);
    }
}