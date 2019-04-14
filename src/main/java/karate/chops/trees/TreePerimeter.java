package karate.chops.trees;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePerimeter {

    public static void main(String... strings) {
        TreePerimeter p = new TreePerimeter();
        p.printTreePerimeter(createCustomBinaryTree());
    }

    private static BinaryTreeNode createCustomBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 3;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 5;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 1;

        root.left = left;
        root.right = right;

        left = new BinaryTreeNode();
        left.value = 6;

        right = new BinaryTreeNode();
        right.value = 2;

        root.left.left = left;
        root.left.right = right;

        left = new BinaryTreeNode();
        left.value = 7;

        right = new BinaryTreeNode();
        right.value = 4;

        root.left.right.left = left;
        root.left.right.right = right;

        left = new BinaryTreeNode();
        left.value = 0;

        right = new BinaryTreeNode();
        right.value = 8;

        root.right.left = left;
        root.right.right = right;

        left = new BinaryTreeNode();
        left.value = 22;

        right = new BinaryTreeNode();
        right.value = 15;

        root.right.right.left = left;
        root.right.right.right = right;

        left = new BinaryTreeNode();
        left.value = 35;

        right = new BinaryTreeNode();
        right.value = 50;

        root.right.right.left.left = left;
        root.right.right.right.right = right;

        return root;
    }

    private static void printTreePerimeter(BinaryTreeNode n) {
        List<Integer> treePerimeter = new ArrayList<>();
        getLeftPerimeter(n, treePerimeter);
        getLeaves(n, treePerimeter);
        getRightPerimeter(n, treePerimeter);
        treePerimeter.stream().forEach(i -> System.out.print(i + " "));
    }

    private static void getRightPerimeter(BinaryTreeNode n, List<Integer> treePerimeter) {
        if (n.right != null)
            n = n.right;
        List<Integer> rightPerimeter = new ArrayList<>();
        while (n.right != null) {
            rightPerimeter.add(n.value);
            n = n.right;
        }
        Collections.reverse(rightPerimeter);
        treePerimeter.addAll(rightPerimeter);
    }

    private static void getLeaves(BinaryTreeNode n, List<Integer> treePerimeter) {
        if (n == null)
            return;
        if (n.left == null && n.right == null)
            treePerimeter.add(n.value);
        getLeaves(n.left, treePerimeter);
        getLeaves(n.right, treePerimeter);
    }

    private static void getLeftPerimeter(BinaryTreeNode n, List<Integer> treePerimeter) {
        while (n.left != null) {
            treePerimeter.add(n.value);
            n = n.left;
        }
    }
}