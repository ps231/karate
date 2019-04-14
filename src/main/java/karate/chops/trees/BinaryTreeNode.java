package karate.chops.trees;

public class BinaryTreeNode {
    public int value;
    public String strValue;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(final int value, final BinaryTreeNode left, final BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public BinaryTreeNode(final String value, final BinaryTreeNode left, final BinaryTreeNode right) {
        this.strValue = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode() {

    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTreeNode other = (BinaryTreeNode) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(strValue!=null)
			return "BinaryTreeNode [value=" + strValue + "]";
		return "BinaryTreeNode [value=" + value + "]";
	}
}
