package karate.chops.trees;

public class CreateBST {

    public static BinaryTreeNode createBinarySearchTree() {
        final BinaryTreeNode root = new BinaryTreeNode(8, null, null);

        root.left = new BinaryTreeNode(6, null, null);
        root.left.left = new BinaryTreeNode(3, null, null);
        root.left.left.left = new BinaryTreeNode(1, null, null);
        root.left.left.right = new BinaryTreeNode(5, null, null);
        root.left.right = new BinaryTreeNode(7, null, null);
        root.right = new BinaryTreeNode(15, null, null);
        root.right.left = new BinaryTreeNode(12, null, null);
        root.right.right = new BinaryTreeNode(20, null, null);

        return root;
    }

    public static BinaryTreeNode createAnotherBinaryTree() {
        final BinaryTreeNode root = new BinaryTreeNode(10, null, null);
        root.left = new BinaryTreeNode(5, null, null);
        root.left.left = new BinaryTreeNode(3, null, null);
        root.left.right = new BinaryTreeNode(7, null, null);
        root.left.right.left = new BinaryTreeNode(6, null, null);
        root.left.right.right = new BinaryTreeNode(9, null, null);
        root.right = new BinaryTreeNode(16, null, null);
        root.right.right = new BinaryTreeNode(28, null, null);
        root.right.right.left = new BinaryTreeNode(19, null, null);
        root.right.right.left.right = new BinaryTreeNode(27, null, null);

        return root;
    }
}
