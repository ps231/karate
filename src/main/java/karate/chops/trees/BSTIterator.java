package karate.chops.trees;

import java.util.Stack;

public class BSTIterator {
    private Stack<BinaryTreeNode> stack = new Stack<>();
    private BinaryTreeNode iterator;

    public BSTIterator(BinaryTreeNode n) {
        if (n == null)
            throw new IllegalArgumentException("invalid input");
        iterator = n;
        while (iterator.left != null) {
            stack.push(iterator);
            iterator = iterator.left;
        }
    }

    public boolean hasNext() {
        return iterator != null;
    }

    public BinaryTreeNode next() {
        BinaryTreeNode current = iterator;
        if (iterator.right != null) {
            iterator = iterator.right;
            while (iterator.left != null) {
                stack.push(iterator);
                iterator = iterator.left;
            }
        } else if (!stack.isEmpty())
            iterator = stack.pop();
        else
            iterator = null;
        return current;
    }

    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(CreateBST.createBinarySearchTree());
        while (iterator.hasNext())
            System.out.println(iterator.next().value);
    }
}