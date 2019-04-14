package karate.chops.trees;

import java.util.*;

public class KthNodeInorderBT {

	public static void main(String... strings) {
//		findKthInorder(BinaryTree.createPerfectBinaryTree(), 6, 0);

		System.out.println(findKthInorder(BinaryTree.createPerfectBinaryTree(), 1));
		System.out.println(findKthInorder(BinaryTree.createPerfectBinaryTree(), 2));
		System.out.println(findKthInorder(BinaryTree.createPerfectBinaryTree(), 3));
		System.out.println(findKthInorder(BinaryTree.createPerfectBinaryTree(), 4));
		System.out.println(findKthInorder(BinaryTree.createPerfectBinaryTree(), 5));
		System.out.println(findKthInorder(BinaryTree.createPerfectBinaryTree(), 6));
		System.out.println(findKthInorder(BinaryTree.createPerfectBinaryTree(), 7));
		System.out.println(findKthInorder(BinaryTree.createPerfectBinaryTree(), 8));
	}

//	private static int findKthInorder(BinaryTreeNode root, int k, int count) {
//		// TODO Auto-generated method stub
//		
//		if(root == null)
//			return count;
//		
//		count = findKthInorder(root.left, k, count);
//		
//		count++;
//		if(count == k) {
//			System.out.println(root.value);
//			System.exit(0);
//		}
//		
//		count = findKthInorder(root.right, k, count);
//		return count;
//	}

	private static int findKthInorder(BinaryTreeNode root, int k) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		int count = 0; 

		while (root.left != null) {
			stack.push(root);
			root = root.left;
		}

		while (root != null) {
			count++;
			if (count == k)
				return root.value;
			if (root.right != null) {
				root = root.right;
				while (root.left != null) {
					stack.push(root);
					root = root.left;
				}
			} else if (!stack.isEmpty()) {
				root = stack.pop();
			} else {
				root = null;
			}
		}
		return -1;
	}

}

class NodeP {
	BinaryTreeNode node;
	int position;

	NodeP(BinaryTreeNode n, int p) {
		node = n;
		position = p;
	}
}
