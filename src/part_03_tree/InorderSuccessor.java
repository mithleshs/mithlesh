package part_03_tree;

public class InorderSuccessor {

	public static TreeNode next = null;

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(12);
		tree.root.left.left = new TreeNode(3);

		tree.inorder(tree.root);
		System.out.println("");
		populateNext(tree.root);
	}

	public static void populateNext(TreeNode node) {
		if (node == null)
			return;
		populateNext(node.right);
		
		if(next!=null)
			System.out.println(node.data+"--->"+next.data);
		else
			System.out.println(node.data+"--->NULL ");
		next = node;
		populateNext(node.left);
	}

}
