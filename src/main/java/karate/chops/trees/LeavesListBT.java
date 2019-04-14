package karate.chops.trees;

import java.util.List;
import java.util.ArrayList;

public class LeavesListBT {

	public static void main(String... strings) {
		List<Integer> leaves = new ArrayList<>();
		printLeavesList(BinaryTree.createLeftSkewedTree(), leaves);

		leaves.stream().forEach(System.out::println);
	}

	private static void printLeavesList(BinaryTreeNode n, List<Integer> leaves) {
		if (n == null)
			return;
		printLeavesList(n.left, leaves);
		printLeavesList(n.right, leaves);
		if (n.left == null && n.right == null)
			leaves.add(n.value);
	}

}
