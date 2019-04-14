package karate.chops.trees;

import java.util.*;

public class RootToLeafPathsBT {
//	public static void main(String...strings ) {
//		int[] path = new int[5];
//		printRToLPaths(BinaryTree.createPerfectBinaryTree(),path,0);
//	}
//
//	private static void printRToLPaths(BinaryTreeNode n, int[] path, int i) {
//		// TODO Auto-generated method stub
//		if(n==null) return;
//		path[i++]=n.value;
//		printRToLPaths(n.left, path,i);
//		printRToLPaths(n.right, path,i);
//		
//		if(n.left == null && n.right == null)
//			for(int j = 0; j<i;j++)
//				System.out.println(path[j]);
//	}

	public static void main(String[] args) {
		printAllRootToLeafPaths(BinaryTree.createPerfectBinaryTree());
		printAllRootToLeafPaths(BinaryTree.createBalancedAsymmetricTree());
		printAllRootToLeafPaths(BinaryTree.createLeftSkewedTree());
	}

	private static void printAllRootToLeafPaths(BinaryTreeNode root) {
		List<String> paths = new ArrayList<String>();
		helper(root, paths, "");
		paths.stream().forEach(System.out::println);
	}

	private static void helper(BinaryTreeNode root, List<String> paths, String intermediate) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			paths.add(intermediate + " " + root.value);
			return;
		}

		helper(root.left, paths, intermediate + " " + root.value);
		helper(root.right, paths, intermediate + " " + root.value);
	}
}
