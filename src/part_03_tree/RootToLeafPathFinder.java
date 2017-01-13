package part_03_tree;

public class RootToLeafPathFinder {

	public static void main(String[] args) {

		int[] path = new int[40];

		BinaryTree tree = new BinaryTree();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		pathFinder(tree.root, path, 0);

	}

	public static void pathFinder(TreeNode node, int[] path, int pathLength) {

		if (node != null) {
			path[pathLength] = node.data;
			pathLength++;
		}
		else 
			return;
		
		if (node.left == null && node.right == null) {
			print(path,pathLength);
		} else {
			pathFinder(node.left, path, pathLength);
			pathFinder(node.right, path, pathLength);
		}

	}

	public static void print(int[] array,int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}

}
