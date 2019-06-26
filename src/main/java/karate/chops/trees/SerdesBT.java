package karate.chops.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerdesBT {

    public static void main(String[] args) {
        List<String> serializedTree = serialize(BinaryTree.createPerfectBinaryTree());
        serializedTree.stream().forEach(System.out::println);
    }

    private static List<String> serialize(BinaryTreeNode root) {
        if (root == null)
            return null;
        List<String> s = new ArrayList<>();
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                BinaryTreeNode n = q1.poll();
                if (n != null) {
                    s.add("" + n.value);
                    q2.offer(n.left);
                    q2.offer(n.right);
                } else {
                    s.add(null);
                }
            }
            while (!q2.isEmpty()) {
                BinaryTreeNode n = q2.poll();
                if (n != null) {
                    s.add("" + n.value);
                    q1.offer(n.left);
                    q1.offer(n.right);
                } else {
                    s.add(null);
                }
            }
        }
        return s;
    }

//    private static BinaryTreeNode deserialize(List<String> s){
//        if(s==null||s.size()==0)
//            return null;
//        BinaryTreeNode root = new BinaryTreeNode(s.get(0));
//        BinaryTreeNode iter = root;
//
//        int nonNullNodes = 1;
//        int maxNodesToRead = nonNullNodes*2;
//        int i = 1;
//        int readUpto = i + maxNodesToRead;
//        nonNullNodes = 0;
//        while(true){
//            while(i < readUpto){
//                if(s.get(i)!=null){
//                    iter.left = s.get(i);
//                    nonNullNodes++;
//                } else
//                    iter.left = null;
//                if(i+1<maxNodesToRead){
//                    if(s.get(i+1)!=null){
//                        iter.right = s.get(i+1);
//                        nonNullNodes++;
//                    } else
//                        iter.right = null;
//                }
//                i+=2;
//            }
//            maxNodesToRead = nonNullNodes*2;
//            readUpto = i + maxNodesToRead;
//        }
//
//        return root;
//    }
}

