package part_03_tree;

public class BuildTree {

	static int preIndex = 0;

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		int inPath[] = new int[] { 1, 2, 3, 4, 5, 6 };
		int prePath[] = new int[] { 4, 2, 1, 3, 6, 5 };
		int end = inPath.length;
		tree.root = buildTree(inPath, prePath, 0, end-1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.inorder(tree.root);

	}

	public static TreeNode buildTree(int[] inPath, int prePath[], int start,
			int end) {

		if (start > end) {
			return null;
		}

		TreeNode node = new TreeNode(prePath[preIndex]);
		preIndex++;
		if (start == end) {
			return node;
		}

		int inOrderIndex = searchIndexInInOrder(inPath, start, end, node.data);

		node.left = buildTree(inPath, prePath, start, inOrderIndex - 1);
		node.right = buildTree(inPath, prePath, inOrderIndex + 1, end);
		return node;
	}

	public static int searchIndexInInOrder(int[] inPath, int start, int end,
			int value) {
		int inOrderIndex = 0;
		for (int i = start; i <= end; i++) {
			if (value == inPath[i]) {
				inOrderIndex = i;
				return inOrderIndex;
			}
		}
		return inOrderIndex;
	}

}
