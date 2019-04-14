package karate.chops.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalBT {
	
	public static void main(String...strings ) {
		levelOrderPrinting(BinaryTree.createSkewedBalancedTree());
	}

	private static void levelOrderPrinting(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		if(node == null)return;
		
		Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> q2 = new LinkedList<>();
		
		q1.add(node);
		
		while(!q1.isEmpty() || !q2.isEmpty()) {
			while(!q1.isEmpty()) {
				BinaryTreeNode n = q1.poll();
				System.out.print(n.value + " ");
				if(n.left!=null) q2.offer(n.left);
				if(n.right!=null)q2.offer(n.right);
			}
			System.out.println("");
			while(!q2.isEmpty()) {
				BinaryTreeNode n = q2.poll();
				System.out.print(n.value + " ");
				if(n.left!=null) q1.offer(n.left);
				if(n.right!=null)q1.offer(n.right);
			}
			System.out.println("");
		}
	}
}
