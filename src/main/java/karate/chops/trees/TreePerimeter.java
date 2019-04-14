package karate.chops.trees;

import java.util.*;

public class TreePerimeter {
	
	public static void main(String...strings) {
		TreePerimeter p = new TreePerimeter();
		p.printTreePerimeter(createCustomBinaryTree());
	}
	
	private static BinaryTreeNode createCustomBinaryTree() {BinaryTreeNode root = new BinaryTreeNode();
    root.value = 3;

    BinaryTreeNode left = new BinaryTreeNode();
    left.value = 5;

    BinaryTreeNode right = new BinaryTreeNode();
    right.value = 1;

    root.left = left;
    root.right = right;

    left = new BinaryTreeNode();
    left.value = 6;

    right = new BinaryTreeNode();
    right.value = 2;

    root.left.left = left;
    root.left.right = right;

    left = new BinaryTreeNode();
    left.value = 7;
    
    right = new BinaryTreeNode();
    right.value = 4;
    
    root.left.right.left = left;
    root.left.right.right = right;
    
    left = new BinaryTreeNode();
    left.value = 0;

    right = new BinaryTreeNode();
    right.value = 8;

    root.right.left = left;
    root.right.right = right;
    
    left = new BinaryTreeNode();
    left.value = 22;
    
    right = new BinaryTreeNode();
    right.value = 15;
    
    root.right.right.left = left;
    root.right.right.right = right;
    
    left = new BinaryTreeNode();
    left.value = 35;
    
    right = new BinaryTreeNode();
    right.value = 50;
    
    root.right.right.left.left = left;
    root.right.right.right.right = right;
    
    return root;
    }

	private void printTreePerimeter(BinaryTreeNode root){
		Set<Integer> perimeter = new LinkedHashSet<Integer>();
		BinaryTreeNode iter = root;
		addLeftPerimeter(iter, perimeter);
		iter=root;
		addLeaves(iter, perimeter);
		iter=root;
		addRightPerimeter(iter, perimeter);
		printPerimeter(perimeter);
	}

	private void addLeftPerimeter(BinaryTreeNode root, Set<Integer> perimeter){
		while(root!=null){
			perimeter.add(root.value);
			root = root.left;
		}
	}

	private void addLeaves(BinaryTreeNode root, Set<Integer> perimeter){
		if(root == null)
			return;
		addLeaves(root.left, perimeter);
		addLeaves(root.right, perimeter);

		if(root.left == null && root.right == null)
			perimeter.add(root.value);
	}

	private void addRightPerimeter(BinaryTreeNode root, Set<Integer> perimeter){
		if(root == null)
			return;
		addRightPerimeter(root.right, perimeter);
		perimeter.add(root.value);
	}

	private void printPerimeter(Set<Integer> perimeter){
		perimeter.stream().forEach(System.out::println);
	}
}
