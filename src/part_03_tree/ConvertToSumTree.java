package part_03_tree;

public class ConvertToSumTree {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(-2);
		tree.root.right = new TreeNode(6);
		tree.root.left.left = new TreeNode(8);
		tree.root.left.right = new TreeNode(-4);
		tree.root.right.left = new TreeNode(7);
		tree.root.right.right = new TreeNode(5);

		tree.inorder(tree.root);
		System.out.println("");

		toSumTree(tree.root);

		tree.inorder(tree.root);
		System.out.println("");
	}

	public static int toSumTree(TreeNode node) {
		if (node == null)
			return 0;

		int oldV = node.data;

		node.data = toSumTree(node.left) + toSumTree(node.right);

		return node.data + oldV;
	}

}
