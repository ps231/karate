package karate.chops.trees;

import java.util.*;

//given two binary trees, check if the levels are anagrams of each other
public class BTAnagramLevels {

    public static void main(String[] args) {
        BinaryTreeNode n1 = createBinaryTree1();
        BinaryTreeNode n2 = createBinaryTree2();

        System.out.println(areLevelsAnagram(n1, n2));
        n2.right = null;
        System.out.println(areLevelsAnagram(n2, n1));
        System.out.println(areLevelsAnagram(null, n2));
        System.out.println(areLevelsAnagram(n1, null));
    }

    private static BinaryTreeNode createBinaryTree1() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 2;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 3;

        root.left = left;
        root.right = right;

        left = new BinaryTreeNode();
        left.value = 4;

        right = new BinaryTreeNode();
        right.value = 5;

        root.left.left = left;
        root.left.right = right;

        left = new BinaryTreeNode();
        left.value = 6;

        right = new BinaryTreeNode();
        right.value = 7;

        root.right.left = left;
        root.right.right = right;

        return root;
    }

    private static BinaryTreeNode createBinaryTree2() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 3;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 2;

        root.left = left;
        root.right = right;

        left = new BinaryTreeNode();
        left.value = 6;

        right = new BinaryTreeNode();
        right.value = 5;

        root.left.left = left;
        root.left.right = right;

        left = new BinaryTreeNode();
        left.value = 4;

        right = new BinaryTreeNode();
        right.value = 7;

        root.right.left = left;
        root.right.right = right;

        return root;
    }

    private static boolean areLevelsAnagram(BinaryTreeNode n1, BinaryTreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        if (n1 == null || n2 == null)
            return false;

        Queue<BinaryTreeNode> q11 = new LinkedList<>();
        Queue<BinaryTreeNode> q12 = new LinkedList<>();

        Queue<BinaryTreeNode> q21 = new LinkedList<>();
        Queue<BinaryTreeNode> q22 = new LinkedList<>();

        q11.offer(n1);
        q21.offer(n2);

        Map<Integer, Integer> nodeCount = null;
        while (!q11.isEmpty() || !q12.isEmpty() || !q21.isEmpty() || !q22.isEmpty()) {
            if (!q11.isEmpty() && !q21.isEmpty()) {
                nodeCount = new HashMap<>();
                while (!q11.isEmpty()) {
                    BinaryTreeNode t = q11.poll();
                    if (t.left != null)
                        q12.offer(t.left);
                    if (t.right != null)
                        q12.offer(t.right);
                    if (!nodeCount.containsKey(t.value))
                        nodeCount.put(t.value, 1);
                    else
                        nodeCount.put(t.value, nodeCount.get(t.value) + 1);
                }
                while (!q21.isEmpty()) {
                    BinaryTreeNode t = q21.poll();
                    if (!nodeCount.containsKey(t.value))
                        return false;
                    if (nodeCount.get(t.value) == 1)
                        nodeCount.remove(t.value);
                    else
                        nodeCount.put(t.value, nodeCount.get(t.value) - 1);
                    if (t.left != null)
                        q22.offer(t.left);
                    if (t.right != null)
                        q22.offer(t.right);
                }
                if (!nodeCount.isEmpty())
                    return false;

            }
            if (!q12.isEmpty() && !q22.isEmpty()) {
                nodeCount = new HashMap<>();
                while (!q12.isEmpty()) {
                    BinaryTreeNode t = q12.poll();
                    if (t.left != null)
                        q11.offer(t.left);
                    if (t.right != null)
                        q11.offer(t.right);
                    if (!nodeCount.containsKey(t.value))
                        nodeCount.put(t.value, 1);
                    else
                        nodeCount.put(t.value, nodeCount.get(t.value) + 1);
                }
                while (!q22.isEmpty()) {
                    BinaryTreeNode t = q22.poll();
                    if (!nodeCount.containsKey(t.value))
                        return false;
                    if (nodeCount.get(t.value) == 1)
                        nodeCount.remove(t.value);
                    else
                        nodeCount.put(t.value, nodeCount.get(t.value) - 1);
                    if (t.left != null)
                        q21.offer(t.left);
                    if (t.right != null)
                        q21.offer(t.right);
                }
                if (!nodeCount.isEmpty())
                    return false;

            }
        }
        return true;
    }
}