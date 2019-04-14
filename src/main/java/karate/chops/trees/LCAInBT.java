package karate.chops.trees;

public class LCAInBT {
	public static void main(String[] args) {
		printLCA(findLCA(BinaryTree.createPerfectBinaryTree(), 7, 8));
		printLCA(findLCA(BinaryTree.createPerfectBinaryTree(), 4, 6));
		printLCA(findLCA(BinaryTree.createPerfectBinaryTree(), 2, 4));
		printLCA(findLCA(BinaryTree.createPerfectBinaryTree(), 3, 7));
		printLCA(findLCA(BinaryTree.createPerfectBinaryTree(), 7, 6));
	}

	private static void printLCA(BinaryTreeNode n) {
		if (n == null)
			System.out.println("LCA not found");
		else
			System.out.println(n.value);
	}

	private static BinaryTreeNode findLCA(BinaryTreeNode n, int n1, int n2) {
		LCADetails details = lcaHelper(n, n1, n2);
		if (details.noOfNodes == 2)
			return details.lca;
		return null;
	}

	private static LCADetails lcaHelper(BinaryTreeNode n, int v1, int v2) {
		if (n == null)
			return new LCADetails(0, null);

		LCADetails left = lcaHelper(n.left, v1, v2);
		if (left.noOfNodes == 2)
			return left;
		LCADetails right = lcaHelper(n.right, v1, v2);
		if (right.noOfNodes == 2)
			return right;
		if (n.value == v1 || n.value == v2)
			if (left.noOfNodes == 1 || right.noOfNodes == 1)
				return new LCADetails(2, n);
			else
				return new LCADetails(1, null);

		if (left.noOfNodes == 1 && right.noOfNodes == 1)
			return new LCADetails(2, n);

		return new LCADetails(left.noOfNodes + right.noOfNodes, null);
	}
}

class LCADetails {
	int noOfNodes;
	BinaryTreeNode lca;

	LCADetails(int count, BinaryTreeNode n) {
		noOfNodes = count;
		lca = n;
	}
}
