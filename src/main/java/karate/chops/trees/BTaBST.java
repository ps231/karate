package karate.chops.trees;

public class BTaBST {

    public static void main(String... strings) {
        System.out.println(isBST(CreateBST.createBinarySearchTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBST(CreateBST.createAnotherBinaryTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBST(BinaryTree.createBalancedTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isBST(BinaryTreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;
        return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
    }
}
