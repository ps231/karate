package karate.chops.trees;

import java.util.ArrayList;
import java.util.List;

public class KLargestNodeBST {
    public static void main(String... args) {
        System.out.println(KLargestNodeBST.kLargest(CreateBST.createBinarySearchTree(), 3));
        System.out.println(KLargestNodeBST.kLargest(CreateBST.createBinarySearchTree(), 5));
        System.out.println(KLargestNodeBST.kLargest(CreateBST.createBinarySearchTree(), 1));
        System.out.println(KLargestNodeBST.kLargest(CreateBST.createBinarySearchTree(), 19));
    }

    private static int kLargest(BinaryTreeNode n, int k) {
        if (n == null || k < 0)
            throw new IllegalArgumentException("invalid input");
        List<BinaryTreeNode> largest = new ArrayList<>();
        helper(n, k, largest);
        if (k > largest.size())
            throw new IllegalArgumentException("invalid input");
        return largest.get(largest.size() - 1).value;
    }

    private static void helper(BinaryTreeNode n, int k, List<BinaryTreeNode> largest) {
        if (n == null)
            return;
        helper(n.right, k, largest);
        if (largest.size() == k)
            return;
        largest.add(n);
        helper(n.left, k, largest);
    }
}
