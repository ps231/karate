package karate.chops.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthInBT {
    public static void main(String[] args) {
        System.out.println(maxWidth(BinaryTree.createPerfectBinaryTree()));
        System.out.println(maxWidth(BinaryTree.createBalancedTree()));
        System.out.println(maxWidth(BinaryTree.createTreeForFlattening()));
        System.out.println(maxWidth(null));
    }

    private static int maxWidth(BinaryTreeNode n) {
        int maxWidth = Integer.MIN_VALUE;
        if (n == null)
            return maxWidth;
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();
        q1.offer(n);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            maxWidth = getMaxWidth(q1, maxWidth);
            traverseLevel(q1, q2);
            maxWidth = getMaxWidth(q2, maxWidth);
            traverseLevel(q2, q1);
        }
        return maxWidth;
    }

    private static void traverseLevel(final Queue<BinaryTreeNode> currentLevelQueue, final Queue<BinaryTreeNode> nextLevelQueue) {
        while (!currentLevelQueue.isEmpty()) {
            BinaryTreeNode t = currentLevelQueue.poll();
            if (t.left != null)
                nextLevelQueue.offer(t.left);
            if (t.right != null)
                nextLevelQueue.offer(t.right);
        }
    }

    private static int getMaxWidth(final Queue<BinaryTreeNode> q, int currentMaxWidth) {
        if (!q.isEmpty())
            currentMaxWidth = Math.max(currentMaxWidth, q.size());
        return currentMaxWidth;
    }
}
