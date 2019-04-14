package karate.chops.trees;

public class PrevNodeBST {
	
	public static void main(String...strings ) {
		PrevNodeBST b = new PrevNodeBST();
		System.out.println(b.prevElem(CreateBST.createBinarySearchTree(), 12).value);
		System.out.println(b.prevElem(CreateBST.createBinarySearchTree(), 5).value);
		System.out.println(b.prevElem(CreateBST.createBinarySearchTree(), 15).value);
		System.out.println(b.prevElem(CreateBST.createBinarySearchTree(), 8).value);
		System.out.println(b.prevElem(CreateBST.createBinarySearchTree(), 20).value);
	}
	
	private BinaryTreeNode prevElem(BinaryTreeNode root, int val) {
		
		BinaryTreeNode iter = root;
		BinaryTreeNode prevElem = null;
		
		while(iter!=null) {
			if(iter.value < val) {
				prevElem = iter;
				iter = iter.right;
			} else if(iter.value > val)
				iter = iter.left;
			else
				break;
		}
		
		if(iter.left==null)
			return prevElem;
		else {
			iter = iter.left;
			while(iter.right!=null)
				iter = iter.right;
			return iter;
		}
		
		
	}

}
