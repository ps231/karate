package karate.chops.trees;

public class NextLargestBST {

	public static void main(String... strings) {
		NextLargestBST b = new NextLargestBST();
		System.out.println(b.nextLargest(CreateBST.createBinarySearchTree(), 12).value);
		System.out.println(b.nextLargest(CreateBST.createBinarySearchTree(), 5).value);
		System.out.println(b.nextLargest(CreateBST.createBinarySearchTree(), 15).value);
		System.out.println(b.nextLargest(CreateBST.createBinarySearchTree(), 8).value);
		System.out.println(b.nextLargest(CreateBST.createBinarySearchTree(), 20).value);
	}

//	private BinaryTreeNode nextLargest(BinaryTreeNode root, int val) {
//		BinaryTreeNode iter = root;
//		BinaryTreeNode nextLargest = null;
//		
//		while(iter != null) {
//			if(iter.value > val) {
//				nextLargest = iter;
//				iter = iter.left;
//			} else if (iter.value < val)
//				iter = iter.right;
//			else break;
//		}
//		
//		if(iter.right == null)
//			return nextLargest;
//		else {
//			iter = iter.right;
//			while(iter.left != null)
//				iter = iter.left;
//			return iter;
//		}
//	}

	private BinaryTreeNode nextLargest(BinaryTreeNode root, int val) {
		if (root == null)
			return null;
		BinaryTreeNode successor = null;

		while (root != null) {
			if (root.value > val) {
				successor = root;
				root = root.left;
			} else if (root.value < val) {
				root = root.right;
			} else {
				if (root.right != null) {
					successor = root.right;
					while (successor.left != null)
						successor = successor.left;
					return successor;
				} else {
					return successor;
				}
			}
		}

		return successor;
	}

}
