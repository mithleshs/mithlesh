package part_03_tree;

/* A complete binary tree is a binary tree in which every level, 
 except possibly the last, is completely filled, 
 and all nodes are as far left as possible.*/

public class CompleteBinaryTree {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(-2);
		tree.root.right = new TreeNode(7);
		tree.root.left.left = new TreeNode(8);
		tree.root.left.right = new TreeNode(-4);

		System.out.println("Is Complete Binary Tree : "
				+ isCompleteBinaryTree(tree.root));
	}

	public static boolean isCompleteBinaryTree(TreeNode node) {
		if (node == null)
			return true;
		if (node.left == null && node.right != null)
			return false;
		if (node.left == null && node.right == null)
			return true;
		return node.left != null && isCompleteBinaryTree(node.left)
				&& isCompleteBinaryTree(node.right);
	}

}
