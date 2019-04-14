package karate.chops.trees;

import java.util.*;

public class RootToLeafPathsBT {
    public static void main(String[] args) {
        printAllRootToLeafPaths(BinaryTree.createPerfectBinaryTree());
        printAllRootToLeafPaths(BinaryTree.createBalancedAsymmetricTree());
        printAllRootToLeafPaths(BinaryTree.createLeftSkewedTree());
    }

    private static void printAllRootToLeafPaths(BinaryTreeNode root) {
        helper(root, new ArrayList<Integer>());
    }

    private static void helper(BinaryTreeNode n, List<Integer> intermediate) {
        if (n == null)
            return;

        if (n.left == null && n.right == null) {
            print(intermediate, n.value);
            return;
        }

        intermediate.add(n.value);
        helper(n.left, intermediate);
        helper(n.right, intermediate);
        intermediate.remove(intermediate.size() - 1);
    }

    private static void print(List<Integer> intermediate, int val) {
        intermediate.stream().forEach(i -> System.out.print(i + " "));
        System.out.println(val);
    }
}