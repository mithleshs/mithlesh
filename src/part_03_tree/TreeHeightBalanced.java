package part_03_tree;

/*An empty tree is height-balanced. A non-empty binary tree T is balanced if:
 1) Left subtree of T is balanced
 2) Right subtree of T is balanced
 3) The difference between heights of left subtree and right subtree is not more than 1.
 */
public class TreeHeightBalanced {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.left.left.left = new TreeNode(8);

		int heightOfLeftSubtree = tree.height(tree.root.getLeft());
		int heightOfRightSubtree = tree.height(tree.root.getRight());

		if (heightOfLeftSubtree - heightOfRightSubtree > 1)
			System.out.println("Tree is not balanced");
		else
			System.out.println("Tree is balanced");

	}

}
