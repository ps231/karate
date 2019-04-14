package karate.chops.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPrintingBT {
	
	public static void main(String...strings ) {
//		levelOrderTraversal(BinaryTree.createBalancedAsymmetricTree());
		levelOrderTraversal(BinaryTree.createSkewedBalancedTree());
	}

	private static void levelOrderTraversal(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		if(node == null)return;
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(node);
		
		while(!q.isEmpty()) {
			BinaryTreeNode n = q.poll();
			System.out.print(n.value + " ");
			if(n.left!=null) q.offer(n.left);
			if(n.right!=null)q.offer(n.right);
		}
	}

}
