package karate.chops.trees;

import java.util.Stack;

public class BSTIterator {
    private BinaryTreeNode iter;
    private Stack<BinaryTreeNode> stack = new Stack<>();

    public BSTIterator(BinaryTreeNode root) {
        if (root == null)
            iter = null;
        else {
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }
            iter = root;
        }
    }

    public boolean hasNext() {
        return iter != null;
    }

    public BinaryTreeNode getNext() {
        BinaryTreeNode result = iter;

        if (iter.right == null) {
            if (!stack.isEmpty())
                iter = stack.pop();
            else {
                iter = null;
            }
        } else {
            iter = iter.right;
            while (iter.left != null) {
                stack.push(iter);
                iter = iter.left;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BSTIterator iter = new BSTIterator(CreateBST.createBinarySearchTree());
        while (iter.hasNext()) {
            System.out.println(iter.getNext().value);
        }
    }
}