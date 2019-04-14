package karate.chops.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalBT {

    public static void main(String... strings) {
        levelOrderPrinting(BinaryTree.createPerfectBinaryTree());
        levelOrderPrinting(BinaryTree.createLeftSkewedTree());
        levelOrderPrinting(BinaryTree.createSkewedBalancedTree());
    }

    private static void levelOrderPrinting(BinaryTreeNode n) {
        if (n == null)
            return;
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();

        q1.offer(n);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            traverseLevel(q1, q2);
            traverseLevel(q2, q1);
        }
    }

    private static void traverseLevel(Queue<BinaryTreeNode> currentLevel, Queue<BinaryTreeNode> nextLevel) {
        while (!currentLevel.isEmpty()) {
            BinaryTreeNode t = currentLevel.poll();
            offerNonNullNode(t.left, nextLevel);
            offerNonNullNode(t.right, nextLevel);
            System.out.print(t.value + " ");
        }
        System.out.println("");
    }

    private static void offerNonNullNode(BinaryTreeNode n, Queue<BinaryTreeNode> q) {
        if (n != null)
            q.offer(n);
    }
}