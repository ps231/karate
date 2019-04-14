package karate.chops.trees;

public class KthSmallestBST {
	private BinaryTreeNode kthSmallest;
	int count;
	
	public static void main(String...args) {
		KthSmallestBST k = new KthSmallestBST();
//		k.kthSmallest(CreateBST.createBinarySearchTree(), 4);
//		System.out.println(k.kthSmallest.value);
		
		k.kthSmallest(BinaryTree.createPerfectBinaryTree(), 5);
		System.out.println(k.kthSmallest.value);
	}
	
	public void kthSmallest(BinaryTreeNode node, int k) {
		if(node == null)
			return;
		
		kthSmallest(node.left, k);
		count++;
		if(count == k)
			kthSmallest = node;
		kthSmallest(node.right, k);
	}

}
