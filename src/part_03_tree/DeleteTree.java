package part_03_tree;

/**
 * To delete a tree we must traverse all the nodes of the tree and delete them
 * one by one. So which traversal we should use – Inorder or Preorder or
 * Postorder. Answer is simple – Postorder, because before deleting the parent
 * node we should delete its children nodes first
 */
public class DeleteTree {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		deleteTree(tree.root);
		tree.root=null;

	}

	public static void deleteTree(TreeNode node) {
		if (node == null)
			return;
		deleteTree(node.left);
		deleteTree(node.right);
		System.out.println("Deleting Node : "+node.data);
		node = null;
	}

}
