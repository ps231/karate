package karate.chops.trees;

import java.util.ArrayList;
import java.util.List;

public class KLargestNodesBST {
	public static void main(String... args) {
		KLargestNodesBST k = new KLargestNodesBST();
		List<Integer> max = new ArrayList<Integer>();
		k.klargest(CreateBST.createBinarySearchTree(), 3, max);
		max.stream().forEach(System.out::println);

		max = new ArrayList<Integer>();
		k.klargest(CreateBST.createBinarySearchTree(), 5, max);
		max.stream().forEach(System.out::println);

		max = new ArrayList<Integer>();
		k.klargest(CreateBST.createBinarySearchTree(), 1, max);
		max.stream().forEach(System.out::println);
	}

//	public void klargest(BinaryTreeNode node, int k, List<Integer> max) {
//		if(k == max.size() || node == null)
//			return;
//		klargest(node.right, k, max);
//		if(max.size() < k)
//			max.add(node.value);
//		klargest(node.left, k, max);
//	}

	public void klargest(BinaryTreeNode n, int k, List<Integer> max) {
		if (n == null)
			return;

		klargest(n.right, k, max);
		if (max.size() == k)
			return;
		max.add(n.value);
		klargest(n.left, k, max);
	}

}
