package karate.chops.trees;
import java.util.*;
public class ReverseAlternateLevelsOfBT {
	
	
	public static void main(String[] args) {
		BinaryTreeNode reversed = reverseLevels(BinaryTree.createPerfectBinaryTree());
		BinaryTree.printTreeInorder(reversed);
	}
	private static BinaryTreeNode reverseLevels(BinaryTreeNode root){
		if(root==null)
			return root;

		Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();

		BinaryTreeNode iter = root;
		BinaryTreeNode nextIter = root;
	
		s1.push(iter.left);
		s1.push(iter.right);
		
		while(!s1.isEmpty() || !s2.isEmpty()){
			iter = root;
//			while(iter.left!=null)
//				iter = iter.left;
			while(!s1.isEmpty()){
			iter.left = s1.pop();
			nextIter = iter.left;
			s2.push(iter.left.right);
			s2.push(iter.right.left);
			iter.right = s1.pop();
			s2.push(iter.right.right);
			s2.push(iter.right.left);
			}

			iter = root;
			while(iter.left!=null)
				iter = iter.left;

			while(!s2.isEmpty()){
				iter.left = s2.pop();
				nextIter = iter.left;
				s1.push(iter.left.left);
				s1.push(iter.left.right);
				iter.right = s2.pop();
				s1.push(iter.right.left);
				s1.push(iter.right.right);
			}
		}
		return root;
	}
}
