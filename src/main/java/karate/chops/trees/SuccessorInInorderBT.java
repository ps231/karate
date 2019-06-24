package karate.chops.trees;

import java.util.Stack;

public class SuccessorInInorderBT {
    public static void main(String... strings) {
        printSuccessor(findSuccessor(BinaryTree.createPerfectBinaryTree(), 1));
        printSuccessor(findSuccessor(BinaryTree.createPerfectBinaryTree(), 2));
        printSuccessor(findSuccessor(BinaryTree.createPerfectBinaryTree(), 3));
        printSuccessor(findSuccessor(BinaryTree.createPerfectBinaryTree(), 4));
        printSuccessor(findSuccessor(BinaryTree.createPerfectBinaryTree(), 5));
        printSuccessor(findSuccessor(BinaryTree.createPerfectBinaryTree(), 6));
        printSuccessor(findSuccessor(BinaryTree.createPerfectBinaryTree(), 7));
        printSuccessor(findSuccessor(BinaryTree.createPerfectBinaryTree(), 14));
        printSuccessor(findSuccessor(null, 14));
    }

    private static void printSuccessor(BinaryTreeNode node) {
        if (node == null)
            System.out.println("No successor defined, or input node could not be found");
        else
            System.out.println(node.value);
    }

    private static BinaryTreeNode findSuccessor(BinaryTreeNode root, int n) {
        if (root == null)
            return null;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (root.value != n) {
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                if (stack.isEmpty())
                    return null;
                root = stack.pop();
                if (root.right != null)
                    root = root.right;
            }
        }

        if (root.right != null) {
            root = root.right;
            while (root.left != null)
                root = root.left;
            return root;
        }
        if (!stack.isEmpty())
            return stack.pop();
        return null;
    }
}
