package part_03_tree;

public class BuildTree {

	static int preIndex = 0;
	static int fullPreIndex = 0;
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		int inPath[] = new int[] { 1, 2, 3, 4, 5, 6 };
		int prePath[] = new int[] { 4, 2, 1, 3, 6, 5 };
		int end = inPath.length;
		tree.root = buildTree(inPath, prePath, 0, end - 1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.inorder(tree.root);

		System.out
				.println("OutPut to Build Full Binary Tree...here below start");

		int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
		int size = pre.length;

		BinaryTree fullTree = new BinaryTree();

		fullTree.root = buildFullBinaryTree(pre, post, 0, 0, size - 1, size);

		System.out.println("PRE-ORDER");
		fullTree.preorder(fullTree.root);
		System.out.println("");

		System.out.println("Post-ORDER");
		fullTree.postorder(fullTree.root);
		System.out.println("");

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

	/*
	 * A Full Binary Tree is a binary tree where every node has either 0 or 2
	 * children
	 */
	public static TreeNode buildFullBinaryTree(int[] pre, int[] post,
			int fullPreIndex, int lowPostIndex, int highPostIndex, int size) {

		// Base case
		if (fullPreIndex >= size || lowPostIndex > highPostIndex) {
			return null;
		}
		TreeNode root = new TreeNode(pre[fullPreIndex]);
		fullPreIndex++;

		// If the current subarry has only one element, no need to recur
		if (lowPostIndex == highPostIndex)
			return root;

		// Search the next element of pre[] in post[]
		int i;
		for (i = lowPostIndex; i <= highPostIndex; i++)
			if (pre[fullPreIndex] == post[i])
				break;

		// Use the index of element found in postorder to divide postorder array
		// in
		// two parts. Left subtree and right subtree
		if (i <= highPostIndex) {
			root.left = buildFullBinaryTree(pre, post, fullPreIndex, lowPostIndex,
					i, size);
			root.right = buildFullBinaryTree(pre, post, fullPreIndex, i + 1,
					highPostIndex, size);
		}

		return root;
	}

}
