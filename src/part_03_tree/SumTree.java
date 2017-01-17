package part_03_tree;

public class SumTree {

	static int finalResult = 0;

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(26);
		tree.root.left = new TreeNode(10);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(6);
		tree.root.right.right = new TreeNode(3);

		if (isSumTree(tree.root) != 0)
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");

	}

	public static boolean isLeaf(TreeNode node) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null)
			return true;
		return false;
	}

	public static int isSumTree(TreeNode node) {

		int leftSum;
		int rightSum;

		if (node == null || isLeaf(node))
			return 1;

		if (isSumTree(node.left) != 0 && isSumTree(node.right) != 0) {

			if (node.left == null)
				leftSum = 0;
			else if (isLeaf(node.left))
				leftSum = node.left.data;
			else
				leftSum = 2 * (node.left.data);

			if (node.right == null)
				rightSum = 0;
			else if (isLeaf(node.right))
				rightSum = node.right.data;
			else
				rightSum = 2 * (node.right.data);

			if ((node.data == rightSum + leftSum))
				return 1;
			else
				return 0;
		}
		return 0;
	}

}
