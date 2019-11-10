package karate.chops.trees;

import java.util.List;
import java.util.ArrayList;

public class LeavesListBT {
    public static void main(String... strings) {
        List<Integer> leaves = new ArrayList<>();
        getLeaves(BinaryTree.createLeftSkewedTree(), leaves);
        print(leaves);
        System.out.println("");

        leaves = new ArrayList<>();
        getLeaves(BinaryTree.createPerfectBinaryTree(), leaves);
        print(leaves);
    }

    private static void getLeaves(BinaryTreeNode n, List<Integer> leaves) {
        if (n == null)
            return;

        if (n.left == null && n.right == null) {
            leaves.add(n.value);
            return;
        }
        getLeaves(n.left, leaves);
        getLeaves(n.right, leaves);
    }

    private static void print(List<Integer> leaves) {
        leaves.stream().forEach(i -> System.out.print(i + " "));
    }
}