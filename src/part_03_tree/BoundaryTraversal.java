package part_03_tree;

public class BoundaryTraversal {

	public static int[] path = new int[40];
	public static int pathLength = 0;

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(20);
		tree.root.left = new TreeNode(8);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(12);
		tree.root.left.right.left = new TreeNode(10);
		tree.root.left.right.right = new TreeNode(14);
		tree.root.right = new TreeNode(22);
		tree.root.right.right = new TreeNode(25);

		findBoundryPath(tree.root);

		for (int i = 0; i < pathLength; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println("");
	}

	public static void findBoundryPath(TreeNode node) {
		if (node == null)
			return;

		path[pathLength] = node.data; // Store first Root Node
		pathLength++;

		// Print the left boundary in top-down manner.
		printBoundaryLeft(node.left);

		// Print all leaf nodes
		printLeaves(node.left);
		printLeaves(node.right);

		// Print the right boundary in bottom-up manner
		printBoundaryRight(node.right);
	}

	public static void printBoundaryLeft(TreeNode node) {
		if (node != null) {
			if (node.left != null) {
				path[pathLength] = node.data;
				pathLength++;
				printBoundaryLeft(node.left);
			} else if (node.right != null) {
				path[pathLength] = node.data;
				pathLength++;
				printBoundaryLeft(node.right);
			}

			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	public static void printBoundaryRight(TreeNode node) {
		if (node != null) {
			if (node.right != null) {
				printBoundaryRight(node.right);
				path[pathLength] = node.data;
				pathLength++;
			} else if (node.left != null) {
				printBoundaryRight(node.left);
				path[pathLength] = node.data;
				pathLength++;
			}
			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	public static void printLeaves(TreeNode node) {
		if (node != null) {
			printLeaves(node.left);
			if (node.left == null && node.right == null) {
				path[pathLength] = node.data;
				pathLength++;
			}
			printLeaves(node.right);
		}
	}

}
