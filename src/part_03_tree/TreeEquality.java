package part_03_tree;

public class TreeEquality {

	public static void main(String[] args) {

		BinaryTree tree1 = new BinaryTree();
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(2);
		tree1.root.right = new TreeNode(3);
		tree1.root.left.left = new TreeNode(4);
		tree1.root.left.right = new TreeNode(5);

		BinaryTree tree2 = new BinaryTree();
		tree2.root = new TreeNode(1);
		tree2.root.left = new TreeNode(2);
		tree2.root.right = new TreeNode(3);
		tree2.root.left.left = new TreeNode(4);
		tree2.root.left.right = new TreeNode(5);

		System.out.println("Are Equal : "
				+ identicalTrees(tree1.root, tree2.root));
	}

	static boolean identicalTrees(TreeNode a, TreeNode b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty -> compare them */
		if (a != null && b != null)
			return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(
					a.right, b.right));

		/* 3. one empty, one not -> false */
		return false;
	}

}
