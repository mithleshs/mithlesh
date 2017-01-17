package part_03_tree;

public class TreeNode {

	public TreeNode left;
	public TreeNode right;
	public int data;
	
	//ignore below ref variable ...only used for ConnectNodes.java file
	public TreeNode nextRight;

	public TreeNode(int data) {
		super();
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
