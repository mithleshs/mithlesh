package part_03_tree;

public class BinaryTree {

	TreeNode root;

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("PRE-ORDER");
		tree.preorder(tree.root);
		System.out.println("");
		System.out.println("IN-ORDER");
		tree.inorder(tree.root);
		System.out.println("");
		System.out.println("POST-ORDER");
		tree.postorder(tree.root);
		System.out.println(" ");
	}

	void preorder(TreeNode node) {

		// 1. Visit
		// 2. Process Left
		// 3. Process Right

		if (node == null)
			return;

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	void inorder(TreeNode node) {

		// 1. Process Left
		// 2. Visit
		// 3. Process Right

		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	void postorder(TreeNode node) {

		// 1. Process Left
		// 2. Process Right
		// 3. Visit
		
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}

}
