package karate.chops.trees;

public class IsRootToLeafPathEqualToSum {
    public static void main(String[] args) {
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 7));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 12));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 6));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 10));
    }

    private static boolean hasPathEqualsSum(BinaryTreeNode n, int sum) {
        if (n == null)
            return false;
        if (n.left == null && n.right == null && n.value == sum)
            return true;
        return hasPathEqualsSum(n.left, sum - n.value) || hasPathEqualsSum(n.right, sum - n.value);
    }
}