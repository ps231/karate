package karate.chops.trees;

public class IsRootToLeafPathEqualToSum {
    public static void main(String[] args) {
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 7));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 12));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 6));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 10));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 8));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), 11));
        System.out.println(hasPathEqualsSum(BinaryTree.createPerfectBinaryTree(), -1));
        System.out.println(hasPathEqualsSum(null, -1));
    }

    private static boolean hasPathEqualsSum(BinaryTreeNode n, int remainingSum) {
        if (n == null)
            return false;
        if (n.left == null && n.right == null && n.value == remainingSum)
            return true;
        return hasPathEqualsSum(n.left, remainingSum - n.value) || hasPathEqualsSum(n.right, remainingSum - n.value);
    }
}