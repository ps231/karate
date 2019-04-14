package karate.chops.trees;

public class BinaryTree {

    public static BinaryTreeNode createPerfectBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 2;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 3;

        root.left = left;
        root.right = right;

        left = new BinaryTreeNode();
        left.value = 4;

        right = new BinaryTreeNode();
        right.value = 5;

        root.left.left = left;
        root.left.right = right;

        left = new BinaryTreeNode();
        left.value = 6;

        right = new BinaryTreeNode();
        right.value = 7;

        root.right.left = left;
        root.right.right = right;

        return root;
    }

    public static BinaryTreeNode createBalancedTree() {
        BinaryTreeNode root = createPerfectBinaryTree();

        BinaryTreeNode traverse = root.left.left;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 8;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 9;

        traverse.left = left;
        traverse.right = right;

        return root;
    }

    public static BinaryTreeNode createLeftSkewedTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode traverse = root;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 2;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 3;

        traverse.left = left;
        traverse.right = right;

        traverse = traverse.left;

        left = new BinaryTreeNode();
        left.value = 4;

        traverse.left = left;
        traverse = traverse.left;

        left = new BinaryTreeNode();
        left.value = 6;

        traverse.left = left;

        return root;
    }

    public static BinaryTreeNode createSkewedBalancedTree() {
        BinaryTreeNode root = createLeftSkewedTree();

        BinaryTreeNode traverse = root;

        traverse = traverse.right;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 5;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 7;

        traverse.left = left;
        traverse = traverse.left;

        traverse.right = right;

        return root;
    }

    public static BinaryTreeNode createSkewedSymmetricTree() {
        BinaryTreeNode root = createLeftSkewedTree();

        BinaryTreeNode traverse = root;

        traverse = traverse.right;
        traverse.value = 2;


        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 4;

        traverse.right = right;
        traverse = traverse.right;

        right = new BinaryTreeNode();
        right.value = 6;

        traverse.right = right;

        return root;
    }

    public static BinaryTreeNode createSkewedAsymmetricTree() {
        BinaryTreeNode root = createLeftSkewedTree();

        BinaryTreeNode traverse = root;

        traverse = traverse.right;
        traverse.value = 2;


        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 5;

        traverse.right = right;
        traverse = traverse.right;

        right = new BinaryTreeNode();
        right.value = 6;

        traverse.right = right;

        return root;
    }

    public static BinaryTreeNode createTreeForFlattening() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 2;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 5;

        root.left = left;
        root.right = right;

        left = new BinaryTreeNode();
        left.value = 3;

        right = new BinaryTreeNode();
        right.value = 4;

        root.left.left = left;
        root.left.right = right;

//        left = new BinaryTreeNode();
//        left.value = 6;

//        right = new BinaryTreeNode();
//        right.value = 6;

//        root.right.left = left;
//        root.right.right = right;

        return root;
    }

    public static BinaryTreeNode createBalancedSymmetricTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 2;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 2;

        root.left = left;
        root.right = right;

        left = new BinaryTreeNode();
        left.value = 3;

        right = new BinaryTreeNode();
        right.value = 4;

        root.left.left = left;
        root.left.right = right;

        left = new BinaryTreeNode();
        left.value = 4;

        right = new BinaryTreeNode();
        right.value = 3;

        root.right.left = left;
        root.right.right = right;

        return root;

    }

    public static BinaryTreeNode createBalancedAsymmetricTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 2;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 2;

        root.left = left;
        root.right = right;

        left = new BinaryTreeNode();
        left.value = 3;

        right = new BinaryTreeNode();
        right.value = 4;

        root.left.left = left;
        root.left.right = right;

        left = new BinaryTreeNode();
        left.value = 5;

        right = new BinaryTreeNode();
        right.value = 3;

        root.right.left = left;
        root.right.right = right;

        return root;
    }
    
    public static void printTreeInorder(BinaryTreeNode root) {
    	if(root == null)
    		return;
    	printTreeInorder(root.left);
    	if(root.strValue!=null)
    		System.out.print(root.strValue + " ");
    	else
    		System.out.print(root.value + " ");
    	printTreeInorder(root.right);
    }
}
