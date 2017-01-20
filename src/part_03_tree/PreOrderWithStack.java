package part_03_tree;

import java.util.Stack;

/*Pop all items one by one. Do following for every popped item
 a) print it
 b) push its right child
 c) push its left child
 Note that right child is pushed first so that left is processed first*/

public class PreOrderWithStack {

	public static Stack<TreeNode> stack = new Stack<TreeNode>();

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(2);

		System.out.println("PRE-ORDER BY RECURSION");
		tree.preorder(tree.root);
		System.out.println(" ");
		System.out.println("PRE-ORDER BY STACK -> iTERATIVE");
		preOrder(tree.root);
	}

	public static void preOrder(TreeNode root) {

		if (root == null) {
			return;
		}

		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.data + " ");
			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}
}
