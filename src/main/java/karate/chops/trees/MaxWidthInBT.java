package karate.chops.trees;
import java.util.*;
public class MaxWidthInBT {
	
	public static void main(String[] args) {
		System.out.println(maxWidth(BinaryTree.createPerfectBinaryTree()));
		System.out.println(maxWidth(BinaryTree.createBalancedTree()));
		System.out.println(maxWidth(BinaryTree.createTreeForFlattening()));
	}
	private static int maxWidth(BinaryTreeNode n) {
		int width = Integer.MIN_VALUE;
		if(n==null)
			return width;

		Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> q2 = new LinkedList<BinaryTreeNode>();

		q1.offer(n);
		while(!q1.isEmpty() || !q2.isEmpty()){
			if(!q1.isEmpty()){
				width = Math.max(width, q1.size());
				while(!q1.isEmpty()){
					BinaryTreeNode node = q1.poll();
					if(node.left!=null)
						q2.offer(node.left);
					if(node.right!=null)
						q2.offer(node.right);
				}
			}
			if(!q2.isEmpty()){
				width = Math.max(width, q2.size());
				while(!q2.isEmpty()){
					BinaryTreeNode node = q2.poll();
					if(node.left!=null)
						q1.offer(node.left);
					if(node.right!=null)
						q1.offer(node.right);
				}
			}
		}
		return width;
	}
}
