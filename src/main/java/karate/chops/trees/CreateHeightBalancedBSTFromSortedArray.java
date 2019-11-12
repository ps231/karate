package karate.chops.trees;

public class CreateHeightBalancedBSTFromSortedArray {
    public static void main(String[] args) {
        BinaryTree.printTreeInorder(createHeightBalancedBST(new int[]{8, 10, 15, 23, 32, 48, 65}));
        System.out.println();
        BinaryTree.printTreeInorder(createHeightBalancedBST(new int[]{5, 8, 10, 15, 23, 32, 48, 65}));
    }

    private static BinaryTreeNode createHeightBalancedBST(int[] A) {
        if (A == null || A.length == 0)
            return null;
        return helper(A, 0, A.length - 1);
    }

    private static BinaryTreeNode helper(int[] A, int low, int high) {
        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        return new BinaryTreeNode(A[mid], helper(A, low, mid - 1), helper(A, mid + 1, high));
    }
}
