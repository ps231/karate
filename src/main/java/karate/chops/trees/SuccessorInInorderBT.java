package karate.chops.trees;

import java.util.Stack;

public class SuccessorInInorderBT {
	
	public static void main(String...strings) {
		BinaryTreeNode successor = findSuccessor(BinaryTree.createPerfectBinaryTree(), 4);
	}

	private static BinaryTreeNode findSuccessor(BinaryTreeNode root, int n) {
		// TODO Auto-generated method stub
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		if(root==null) return null;
		boolean successorFound = false;
		
		while(!stack.isEmpty() || root != null) {
		while(root.left!=null) {
			stack.push(root);
			root = root.left;
		}
		
		if(n==root.value)
			successorFound = true;
		
		if(root.right == null) {
			
				root = stack.pop();
				
				if(n==root.value)
					successorFound = true;
			
		}
		
		if(root.right!=null)
			root = root.right;
		}
		return null;
	}

}
