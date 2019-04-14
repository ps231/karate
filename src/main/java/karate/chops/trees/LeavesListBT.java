package karate.chops.trees;

import java.util.List;
import java.util.ArrayList;

public class LeavesListBT {

    public static void main(String... strings) {
        List<Integer> leaves = new ArrayList<>();
        printLeavesList(BinaryTree.createLeftSkewedTree(), leaves);
        print(leaves);
        System.out.println("");

        leaves = new ArrayList<>();
        printLeavesList(BinaryTree.createPerfectBinaryTree(), leaves);
        print(leaves);
    }

    private static void printLeavesList(BinaryTreeNode n, List<Integer> leaves) {
        if (n == null)
            return;

        if (n.left == null && n.right == null)
            leaves.add(n.value);

        printLeavesList(n.left, leaves);
        printLeavesList(n.right, leaves);
    }

    private static void print(List<Integer> leaves) {
        leaves.stream().forEach(i -> System.out.print(i + " "));
    }
}