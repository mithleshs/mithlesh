package part_03_tree;

import java.util.HashMap;
import java.util.Map;

public class MaxSumLeafToRoot {

	public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static int numberOfPath = 0;

	public static void main(String[] args) {

		int[] path = new int[40];

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(-2);
		tree.root.right = new TreeNode(7);
		tree.root.left.left = new TreeNode(8);
		tree.root.left.right = new TreeNode(-4);

		pathFinder(tree.root, path, 0);
		System.out.println(map.entrySet());
	}

	public static void pathFinder(TreeNode node, int[] path, int pathLength) {
		if (node != null) {
			path[pathLength] = node.data;
			pathLength++;
		} else
			return;

		if (node.left == null && node.right == null) {
			calculateSum(path, pathLength);
			numberOfPath++;
		} else {
			pathFinder(node.left, path, pathLength);
			pathFinder(node.right, path, pathLength);
		}

	}

	public static void calculateSum(int[] array, int size) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += array[i];
		}
		map.put(numberOfPath, sum);
	}

}
