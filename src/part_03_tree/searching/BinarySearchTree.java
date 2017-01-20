package part_03_tree.searching;

import part_03_tree.BinaryTree;
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
		
		BinaryTree tree=new BinaryTree();
		System.out.println("IN-ORDER");
		tree.inorder(bst.root);
		System.out.println("");
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
}
