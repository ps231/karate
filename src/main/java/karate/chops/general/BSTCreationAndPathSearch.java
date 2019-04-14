package karate.chops.general;

import java.util.ArrayList;
import java.util.List;

/*
 * couldnt add the case where if an element is not present in the tree, return -1
 */
public class BSTCreationAndPathSearch {

	public static void main(String... strings) {
		BSTCreationAndPathSearch s = new BSTCreationAndPathSearch();
		List<Integer> nodes = new ArrayList<Integer>();
		nodes.add(5);
		nodes.add(6);
		nodes.add(3);
		nodes.add(1);
		nodes.add(2);
		nodes.add(4);
		int path = s.helper(nodes, 3, 8);
		System.out.println(path);

	}

	private int helper(List<Integer> nodes, int n1, int n2) {
		// TODO Auto-generated method stub
		BinaryTreeNode root = constructBST(nodes);
		BinaryTreeNode lca = findLCA(n1, n2, root);
		return findPath(n1, n2, lca);
	}

	BinaryTreeNode constructBST(List<Integer> nodes) {
		BinaryTreeNode head = new BinaryTreeNode(nodes.get(0));
		BinaryTreeNode iter = head;

		for (int i = 1; i < nodes.size(); i++) {
			while (iter != null) {
				if (iter.data < nodes.get(i)) {
					if (iter.right != null)
						iter = iter.right;
					else {
						iter.right = new BinaryTreeNode(nodes.get(i));
						break;
					}
				} else {
					if (iter.left != null)
						iter = iter.left;
					else {
						iter.left = new BinaryTreeNode(nodes.get(i));
						break;
					}
				}
			}
			iter = head;
		}
		return head;
	}

	BinaryTreeNode findLCA(int node1, int node2, BinaryTreeNode root) {

		while (root != null) {
			if (root.data < node1 && root.data < node2) {
				root = root.right;
			} else if (root.data > node1 && root.data > node2) {
				root = root.left;
			} else
				break;
		}
		return root;
	}

	int findPath(int node1, int node2, BinaryTreeNode lca) {

		int n1 = findPath(lca, node1);
		int n2 = findPath(lca, node2);

		if (n1 == 0 || n2 == 0)
			return n1 + n2;

		return n1 + n2 + 1;
	}

	int findPath(BinaryTreeNode lca, int n) {
		if (lca.data == n)
			return 0;
		int path = 0;
		while (lca != null) {
			if (lca.data > n) {
				lca = lca.left;
				path++;
			} else if (lca.data < n) {
				lca = lca.right;
				path++;
			} else
				break;
		}
		return path;
	}

}

class BinaryTreeNode {
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int d) {
		data = d;
	}
}
