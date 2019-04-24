package karate.chops.trees;

import java.util.ArrayList;
import java.util.List;

public class LCAInBTAnotherApproach {
    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
        printLCA(findLCA(root, getNode(7), getNode(8)));
        printLCA(findLCA(root, getNode(4), getNode(6)));
        printLCA(findLCA(root, getNode(2), getNode(4)));
        printLCA(findLCA(root, getNode(3), getNode(7)));
        printLCA(findLCA(root, getNode(7), getNode(6)));
    }

    private static BinaryTreeNode getNode(int value) {
        return new BinaryTreeNode(value, null, null);
    }

    private static void printLCA(BinaryTreeNode n) {
        if (n == null)
            System.out.println("LCA not found");
        else
            System.out.println(n.value);
    }

    private static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
        if (root == null || n1 == null || n2 == null)
            return null;
        return getLCA(findRootToNodePath(root, n1), findRootToNodePath(root, n2));
    }

    private static List<BinaryTreeNode> findRootToNodePath(BinaryTreeNode root, BinaryTreeNode n) {
        List<BinaryTreeNode> intermediate = new ArrayList<>();
        helper(root, n, intermediate);
        return intermediate;
    }

    private static boolean helper(BinaryTreeNode root, BinaryTreeNode n, List<BinaryTreeNode> intermediate) {
        if (root == null)
            return false;

        if (root.value == n.value) {
            intermediate.add(root);
            return true;
        }

        intermediate.add(root);
        if (helper(root.left, n, intermediate) || helper(root.right, n, intermediate)) {
            return true;
        }
        intermediate.remove(intermediate.size() - 1);
        return false;
    }

    private static BinaryTreeNode getLCA(List<BinaryTreeNode> p1, List<BinaryTreeNode> p2) {
        if (p1.size() == 0 || p2.size() == 0)
            return null;

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i > j)
            i--;
        while (j > i)
            j--;
        while (i >= 0) {
            if (p1.get(i).value == p2.get(j).value)
                return p1.get(i);
            i--;
            j--;
        }
        return null;
    }
}