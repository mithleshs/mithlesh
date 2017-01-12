package part_03_tree;

/**
 1) Create an empty stack S.
 2) Initialize current node as root
 3) Push the current node to S and set current = current->left until current is NULL
 4) If current is NULL and stack is not empty then 
	 a) Pop the top item from stack.
	 b) Print the popped item, set current = popped_item->right 
	 c) Go to step 3.
 5) If current is NULL and stack is empty then we are done.
 **/

import java.util.Stack;

public class InOrderWithoutRecursion {

	static Stack<TreeNode> stack = new Stack<TreeNode>();

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		// ---------------------Logic Start Here------------------------------//
		TreeNode current = tree.root;
		while (current != null) {
			stack.push(current);
			current = current.left;
		}

		while (!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(current.data + " ");
			if (current.right != null) {
				current = current.right;

				while (current != null) {
					stack.push(current);
					current = current.left;
				}
			}
		}

	}

}
