package karate.chops.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestSubtreeWithDeepestNodes {
	
	public static void main(String...stg) {
		SmallestSubtreeWithDeepestNodes s = new SmallestSubtreeWithDeepestNodes();
		BinaryTreeNode root = createCustomBinaryTree();
		BinaryTreeNode n = s.subtreeWithAllDeepest(root);
		System.out.println(n.value);
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



	public BinaryTreeNode subtreeWithAllDeepest(BinaryTreeNode root) {
        List<NodeDepth> nodes = new ArrayList<NodeDepth>();
        PriorityQueue<NodeDepth> minHeap = new PriorityQueue<NodeDepth>(new Comparator<NodeDepth>() {
           public int compare(NodeDepth n1, NodeDepth n2) {
               return Integer.compare(n1.depth, n2.depth);
           } 
        });
        findNodesWithMaxDepth(root, 0, minHeap);
        return findLCA(minHeap.poll().node, minHeap.poll().node, root);
    }
    
    private void findNodesWithMaxDepth(BinaryTreeNode root, int depth, PriorityQueue<NodeDepth> minHeap) {
        if(root == null)
            return;
        
        findNodesWithMaxDepth(root.left, depth+1, minHeap);
        findNodesWithMaxDepth(root.right, depth+1, minHeap);
        
        if(minHeap.size() < 2)
            minHeap.add(new NodeDepth(root, depth));
        else {
            if(minHeap.peek().depth < depth) {
                minHeap.poll();
                minHeap.add(new NodeDepth(root, depth));
            }
        }
    }
    
    private BinaryTreeNode findLCA(BinaryTreeNode n1, BinaryTreeNode n2, BinaryTreeNode root) {
        BinaryTreeNode[] lca = new BinaryTreeNode[1];
        lcaHelper(n1,n2,root,lca);
        return lca[0];
    }
    
    private boolean lcaHelper(BinaryTreeNode n1, BinaryTreeNode n2, BinaryTreeNode root, BinaryTreeNode[] lca) {
        if(root == null)
            return false;
        
        boolean left = lcaHelper(n1, n2, root.left, lca);
        boolean right = lcaHelper(n1, n2, root.right, lca);
        
        if(left && right)
            lca[0] = root;
        
        if(root.value == n1.value || root.value == n2.value || left || right)
            return true;
        
        return false;
    }
}

class NodeDepth {
    BinaryTreeNode node;
    int depth;
    
    NodeDepth(BinaryTreeNode n, int d){
        node = n;
        depth = d;
    }
}
