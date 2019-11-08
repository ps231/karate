package karate.chops.trees;

public class FindSizeOfBT {
    public static void main(String[] args) {
        System.out.println(findSize(BinaryTree.createPerfectBinaryTree()));
        System.out.println(findSize(BinaryTree.createLeftSkewedTree()));
    }

    private static int findSize(BinaryTreeNode n) {
        if (n == null)
            return 0;
        return findSize(n.left) + findSize(n.right) + 1;
    }
}
