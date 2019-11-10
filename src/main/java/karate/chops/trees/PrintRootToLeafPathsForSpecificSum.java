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
        List<String> allPaths = new ArrayList<>();
        String intermediatePath = "";
        helper(n, sum, allPaths, intermediatePath);
        System.out.println("Tree paths with sum=" + sum + " : " + allPaths.size());
        for (String s : allPaths)
            System.out.println(s);
    }

    private static void helper(BinaryTreeNode n, int remainingSum, List<String> allPaths, String intermediatePath) {
        if (n == null)
            return;
        if (n.left == null && n.right == null && n.value == remainingSum) {
            allPaths.add(intermediatePath + " " + n.value);
            return;
        }
        helper(n.left, remainingSum - n.value, allPaths, intermediatePath + " " + n.value);
        helper(n.right, remainingSum - n.value, allPaths, intermediatePath + " " + n.value);
    }
}