package karate.chops.trees;
import java.util.*;
public class BTInorder {
	
	public static void main(String...strings) {
		BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
//		inorder(root);
		
		List<Integer> inorder = inorderTraversal(root);
		inorder.stream().forEach(System.out::println);
	}
	
	private static void inorder(BinaryTreeNode root) {
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.println(root.value);
		inorder(root.right);
	}
	
	 private static List<Integer> inorderTraversal(BinaryTreeNode root) {
	        
	        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
	        List<Integer> inorder = new ArrayList<Integer>();
	        Set<Integer> visited = new HashSet<Integer>();
	        
	        if(root == null)
	            return inorder;
	        
	        while(root!= null || !stack.isEmpty()) {
	            if(root.left != null && !visited.contains(root.left.value)) {
	                stack.push(root);
	                root = root.left;
	            } else {
	                inorder.add(root.value);
	                visited.add(root.value);
	                if(root.right != null)
	                    root = root.right;
	                else if(stack.isEmpty())
	                	break;
	                else
	                    root = stack.pop();
	            }
	        }
	        return inorder;
	        
	    }

}
