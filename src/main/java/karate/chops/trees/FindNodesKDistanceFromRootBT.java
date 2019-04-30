package karate.chops.trees;

import java.util.ArrayList;
import java.util.List;

public class FindNodesKDistanceFromRootBT {
    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
        printNodesAtKDistanceFromRoot(root);

        root = createCustomBinaryTree();
        printNodesAtKDistanceFromRoot(root);
    }

    private static List<BinaryTreeNode> nodesAtKDistanceFromRoot(BinaryTreeNode root, int k) {
        if (k < 1)
            throw new IllegalArgumentException("invalid input");

        List<BinaryTreeNode> kDistanceNodes = new ArrayList<>();
        helper(root, kDistanceNodes, k, 1);
        return kDistanceNodes;
    }

    private static void helper(BinaryTreeNode root, List<BinaryTreeNode> kDistanceNodes, int k, int level) {
        if (root == null)
            return;
        if (k == level) {
            kDistanceNodes.add(root);
            return;
        }
        helper(root.left, kDistanceNodes, k, level + 1);
        helper(root.right, kDistanceNodes, k, level + 1);
    }

    private static BinaryTreeNode createCustomBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode(20, null, null);
        BinaryTreeNode left = new BinaryTreeNode(10, null, null);
        BinaryTreeNode right = new BinaryTreeNode(30, null, null);
        root.left = left;
        root.right = right;

        left = new BinaryTreeNode(5, null, null);
        right = new BinaryTreeNode(15, null, null);

        root.left.left = left;
        root.left.right = right;

        left = new BinaryTreeNode(12, null, null);
        root.left.right.left = left;

        left = new BinaryTreeNode(25, null, null);
        right = new BinaryTreeNode(40, null, null);
        root.right.left = left;
        root.right.right = right;

        return root;
    }

    private static void printNodesAtKDistanceFromRoot(BinaryTreeNode root) {
        nodesAtKDistanceFromRoot(root, 1).stream().forEach(n -> System.out.print(n.value + " "));
        System.out.println();
        nodesAtKDistanceFromRoot(root, 2).stream().forEach(n -> System.out.print(n.value + " "));
        System.out.println();
        nodesAtKDistanceFromRoot(root, 3).stream().forEach(n -> System.out.print(n.value + " "));
        System.out.println();
        nodesAtKDistanceFromRoot(root, 4).stream().forEach(n -> System.out.print(n.value + " "));
    }
}