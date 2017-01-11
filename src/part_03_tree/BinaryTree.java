package part_03_tree;

/**
 * @1. (Left to Right)Breadth First Traversal (Or Level Order Traversal) / Queue
 * @2. (Top to Bottom)Depth First Traversals / Stack Inorder Traversal
 *     (Left-Root-Right) Preorder Traversal (Root-Left-Right) Postorder
 *     Traversal (Left-Right-Root)
 **/
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
		System.out.println("");
		
		System.out.println("LEVEL-ORDER");
		tree.printLevelOrder(tree.root);
		System.out.println(" ");
		
		System.out.println("LEVEL-ORDER-AT-LEVEL");
		tree.printLevelOrderAtLevel(tree.root);
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

	// BFS Traversal (Level order Traversal)
	void levelOrder(TreeNode node, int level) {
		if (node == null) {
			return;
		}
		if (level == 1) {
			System.out.print(node.data + " ");
		} else if (level > 1) {
			levelOrder(node.left, level - 1);
			levelOrder(node.right, level - 1);
		}
	}

	void printLevelOrder(TreeNode node) {
		int height = height(node);
		for (int i = 1; i <= height; i++)
			levelOrder(node, i);
	}
	
	void printLevelOrderAtLevel(TreeNode node) {
		int height = height(node);
		for (int i = 1; i <= height; i++)
		{
			levelOrder(node, i);
			System.out.println("");
		}
	}

	int height(TreeNode node) {
		if (node == null)
			return 0;
		else {
			int lheight = height(node.left);
			int rheight = height(node.right);

			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

}
