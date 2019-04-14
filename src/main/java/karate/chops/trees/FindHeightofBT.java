package karate.chops.trees;

public class FindHeightofBT {

    public static void main(String[] args) {
        System.out.println(findHeight(BinaryTree.createPerfectBinaryTree()));
        System.out.println(findHeight(BinaryTree.createLeftSkewedTree()));
    }

    private static int findHeight(BinaryTreeNode n) {
        if (n == null)
            return 0;
        return 1 + Math.max(findHeight(n.left), findHeight(n.right));
    }
}
