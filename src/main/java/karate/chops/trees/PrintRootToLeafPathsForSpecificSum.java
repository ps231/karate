package karate.chops.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToLeafPathsForSpecificSum {
    public static void main(String[] args) {
        BinaryTreeNode n = BinaryTree.createPerfectBinaryTree();
        n.left.left.value = 7;
        printPathThatHasExactSum(n, 10);
        printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 11);
        printPathThatHasExactSum(BinaryTree.createPerfectBinaryTree(), 6);
        printPathThatHasExactSum(null, 6);
    }

    private static void printPathThatHasExactSum(BinaryTreeNode n, int sum) {
        List<String> result = new ArrayList<>();
        helper(n, sum, result, "");
        System.out.println("Paths equal to sum: " + result.size());
        result.stream().forEach(System.out::println);
    }

    private static void helper(BinaryTreeNode root, int remainingSum, List<String> paths, String intermediatePath) {
        if (root == null)
            return;
        helper(root.left, remainingSum - root.value, paths, intermediatePath + " " + root.value);
        helper(root.right, remainingSum - root.value, paths, intermediatePath + " " + root.value);
        if (root.left == null && root.right == null && root.value == remainingSum)
            paths.add(intermediatePath + " " + root.value);
    }
}