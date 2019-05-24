package karate.chops.trees;

public class CreateHeightBalancedBSTFromSortedArray {
    public static void main(String[] args) {
        BinaryTree.printTreeInorder(createHeightBalancedBST(new int[]{8, 10, 15, 23, 32, 48, 65}));
        System.out.println("");
        BinaryTree.printTreeInorder(createHeightBalancedBST(new int[]{5, 8, 10, 15, 23, 32, 48, 65}));
    }

    private static BinaryTreeNode createHeightBalancedBST(int[] elements) {
        if (elements == null || elements.length == 0)
            return null;
        return helper(0, elements.length - 1, elements);
    }

    private static BinaryTreeNode helper(int low, int high, int[] elements) {
        if (low > high)
            return null;
        int mid = low + ((high - low) / 2);
        return new BinaryTreeNode(elements[mid], helper(low, mid - 1, elements), helper(mid + 1, high, elements));
    }
}
