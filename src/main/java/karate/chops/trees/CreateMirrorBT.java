package karate.chops.trees;

public class CreateMirrorBT {

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTree.createLeftSkewedTree();
        BinaryTreeNode mirror = createMirror(root);
        printTrees(root, mirror);

        root = BinaryTree.createPerfectBinaryTree();
        mirror = createMirror(root);
        printTrees(root, mirror);
    }

    private static BinaryTreeNode createMirror(BinaryTreeNode root) {
        if (root == null)
            return null;
        return new BinaryTreeNode(root.value, createMirror(root.right), createMirror(root.left));
    }

    private static void printTrees(BinaryTreeNode root, BinaryTreeNode mirror) {
        System.out.print("Original Tree (Inorder): ");
        BinaryTree.printTreeInorder(root);
        System.out.println("");
        System.out.print("Mirror Tree (Inorder): ");
        BinaryTree.printTreeInorder(mirror);
        System.out.println("");
    }
}