package karate.chops.trees;

import java.util.Stack;

public class PrintAlternateLevelsInReverseOfBT {
    public static void main(String[] args) {
        printAlternateLevelsInReverse(getCustomBinaryTree());
        printAlternateLevelsInReverse(null);
    }

    private static BinaryTreeNode getCustomBinaryTree() {
        BinaryTreeNode n = BinaryTree.createPerfectBinaryTree();
        n.left.left.right = new BinaryTreeNode(9, null, null);
        n.right.left.left = new BinaryTreeNode(8, null, null);
        n.right.left.right = new BinaryTreeNode(10, null, null);
        n.right.left.right.left = new BinaryTreeNode(12, null, null);
        n.right.left.right.right = new BinaryTreeNode(15, null, null);
        return n;
    }

    private static void printAlternateLevelsInReverse(BinaryTreeNode n) {
        if (n == null)
            return;
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();
        s1.push(n);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                BinaryTreeNode t = s1.pop();
                System.out.print(t.value + " ");
                if (t.right != null)
                    s2.push(t.right);
                if (t.left != null)
                    s2.push(t.left);
            }
            System.out.println();

            while (!s2.isEmpty()) {
                BinaryTreeNode t = s2.pop();
                System.out.print(t.value + " ");
                if (t.left != null)
                    s1.push(t.left);
                if (t.right != null)
                    s1.push(t.right);
            }
            System.out.println();
        }
    }
}
