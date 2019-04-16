package karate.chops.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthInBT {
    public static void main(String[] args) {
        System.out.println(maxWidth(BinaryTree.createPerfectBinaryTree()));
        System.out.println(maxWidth(BinaryTree.createBalancedTree()));
        System.out.println(maxWidth(BinaryTree.createTreeForFlattening()));
    }

    private static int maxWidth(BinaryTreeNode n) {
        int maxWidth = Integer.MIN_VALUE;

        if (n == null)
            return maxWidth;

        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();

        q1.offer(n);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            maxWidth = traverseLevel(maxWidth, q1, q2);
            maxWidth = traverseLevel(maxWidth, q2, q1);
        }
        return maxWidth;
    }

    private static int traverseLevel(int maxWidth, Queue<BinaryTreeNode> currentLevel, Queue<BinaryTreeNode> nextLevel) {
        maxWidth = getMax(maxWidth, currentLevel);
        while (!currentLevel.isEmpty()) {
            BinaryTreeNode t = currentLevel.poll();
            if (t.left != null)
                nextLevel.offer(t.left);
            if (t.right != null)
                nextLevel.offer(t.right);
        }
        return maxWidth;
    }

    private static int getMax(int currentMax, Queue<BinaryTreeNode> q) {
        return Math.max(currentMax, q.size());
    }
}
