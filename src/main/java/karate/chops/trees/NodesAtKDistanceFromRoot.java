package karate.chops.trees;

import java.util.ArrayList;
import java.util.List;

public class NodesAtKDistanceFromRoot {
    public static void main(String[] args) {
        print(getNodesAtKDistanceFromRoot(BinaryTree.createPerfectBinaryTree(), 1), 1);
        print(getNodesAtKDistanceFromRoot(BinaryTree.createPerfectBinaryTree(), 2), 2);
        print(getNodesAtKDistanceFromRoot(BinaryTree.createPerfectBinaryTree(), 3), 3);
    }

    private static void print(List<BinaryTreeNode> nodes, int k) {
        if (nodes.isEmpty())
            System.out.println("could not find nodes at " + k + " distance from root");
        nodes.stream().forEach(n -> System.out.println(n.value));
    }

    private static List<BinaryTreeNode> getNodesAtKDistanceFromRoot(BinaryTreeNode root, int k) {
        if (root == null || k <= 0)
            return null;

        List<BinaryTreeNode> kDistance = new ArrayList<>();

        helper(root, k, kDistance);
        return kDistance;
    }

    private static void helper(BinaryTreeNode root, int k, List<BinaryTreeNode> kDistanceNodes) {
        if (root == null)
            return;
        if (k == 0) {
            kDistanceNodes.add(root);
            return;
        }
        helper(root.left, k - 1, kDistanceNodes);
        helper(root.right, k - 1, kDistanceNodes);
    }
}
