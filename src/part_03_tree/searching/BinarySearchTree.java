package part_03_tree.searching;

import part_03_tree.TreeNode;

public class BinarySearchTree {

	public TreeNode root = null;

	public BinarySearchTree() {
		root = null;
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);

		int searchKey = 50;
		TreeNode searchedNode = bst.search(bst.root, searchKey);
		if (searchedNode != null && searchedNode.data == searchKey) {
			System.out.println("Found : " + searchKey);
		} else {
			System.out.println("Not Found 404");
		}

		TreeNode minNode=bst.getMin(bst.root);
		TreeNode maxNode=bst.getMax(bst.root);
		System.out.println("Min Node : "+minNode.data);
		System.out.println("Max Node : "+maxNode.data);
	}

	public void insert(int data) {
		root = insertNode(root, data);
	}

	public TreeNode insertNode(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(data);
			return root;
		}

		if (data > root.data)
			root.right = insertNode(root.right, data);
		else if (data < root.data)
			root.left = insertNode(root.left, data);

		return root;
	}

	public TreeNode search(TreeNode node, int data) {
		if (node == null)
			return null;
		if (node.data == data)
			return node;

		if (data > node.data) {
			return search(node.right, data);
		} else {
			return search(node.left, data);
		}
	}

	void deleteKey(int key) {
		root = deleteRec(root, key);
	}

	int minValue(TreeNode root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	TreeNode deleteRec(TreeNode root, int key) {
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (key < root.data)
			root.left = deleteRec(root.left, key);
		else if (key > root.data)
			root.right = deleteRec(root.right, key);

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.data = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	public TreeNode getMin(TreeNode root) {

		if (root == null)
			return null;

		if (root.left == null)
			return root;
		else
			return getMin(root.left);
	}
	
	public TreeNode getMax(TreeNode root) {

		if (root == null)
			return null;

		if (root.right == null)
			return root;
		else
			return getMax(root.right);
	}

}
