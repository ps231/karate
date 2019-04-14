package karate.chops.trees;

import java.util.*;

public class ViewOfBT {
    public static void main(String[] args) {
        System.out.println("LHS View");
        printLHSViewOfBT(BinaryTree.createPerfectBinaryTree(), true);
        System.out.println("RHS View");
        printLHSViewOfBT(BinaryTree.createPerfectBinaryTree(), false);
        System.out.println("LHS View");
        printLHSViewOfBT(BinaryTree.createBalancedAsymmetricTree(), true);
        System.out.println("RHS View");
        printLHSViewOfBT(BinaryTree.createBalancedAsymmetricTree(), false);
        System.out.println("LHS View");
        printLHSViewOfBT(createCustomBinaryTree(), true);
        System.out.println("RHS View");
        printLHSViewOfBT(createCustomBinaryTree(), false);
    }

    private static BinaryTreeNode createCustomBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode(1, null, null);
        root.left = new BinaryTreeNode(2, null, null);
        root.right = new BinaryTreeNode(3, null, null);
        root.right.left = new BinaryTreeNode(4, null, null);
        root.right.right = new BinaryTreeNode(5, null, null);
        root.right.right.right = new BinaryTreeNode(6, null, null);
        return root;
    }

    private static void printLHSViewOfBT(BinaryTreeNode n, boolean isLHS) {
        if (n == null)
            return;

        List<Integer> view = new ArrayList<>();

        Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();
        Queue<BinaryTreeNode> q2 = new LinkedList<BinaryTreeNode>();

        q1.offer(n);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            traverseLevels(view, q1, q2, isLHS);
            traverseLevels(view, q2, q1, isLHS);
        }
        print(view);
    }

    private static void traverseLevels(List<Integer> view, Queue<BinaryTreeNode> currentLevel, Queue<BinaryTreeNode> nextLevel, boolean isLHS) {
        addNodeToView(view, currentLevel);
        while (!currentLevel.isEmpty()) {
            BinaryTreeNode t = currentLevel.poll();
            if (isLHS) {
                offerNodeToNextLevel(t.left, nextLevel);
                offerNodeToNextLevel(t.right, nextLevel);
            } else {
                offerNodeToNextLevel(t.right, nextLevel);
                offerNodeToNextLevel(t.left, nextLevel);
            }
        }
    }

    private static void offerNodeToNextLevel(BinaryTreeNode n, Queue<BinaryTreeNode> nextLevel) {
        if (n != null)
            nextLevel.offer(n);
    }

    private static void addNodeToView(List<Integer> view, Queue<BinaryTreeNode> currentLevel) {
        if (!currentLevel.isEmpty())
            view.add(currentLevel.peek().value);
    }

    private static void print(List<Integer> lhsView) {
        lhsView.stream().forEach(i -> System.out.print(i + " "));
        System.out.println("");
    }
}