package karate.chops.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToSumPathsForSpecificSum {
    public static void main(String[] args) {
        BinaryTreeNode n = BinaryTree.createPerfectBinaryTree();
        n.left.left.value = 7;
        printPathThatHasExactSum(n, 10);
        printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 11);
        printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 6);
    }

    private static void printPathThatHasExactSum(BinaryTreeNode n, int sum) {
        List<String> result = new ArrayList<>();
        helper(n, sum, "", result);
        System.out.println("Paths equal to sum: " + result.size());
        result.stream().forEach(System.out::println);
    }

    private static void helper(BinaryTreeNode n, int sum, String intermediate, List<String> result) {
        if (n == null)
            return;
        if (n.left == null && n.right == null && n.value == sum)
            result.add(intermediate + " " + n.value);
        helper(n.left, sum - n.value, intermediate + " " + n.value, result);
        helper(n.right, sum - n.value, intermediate + " " + n.value, result);
    }
}