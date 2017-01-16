package part_03_tree;

//Checks if tree can be folded or not

/*IsFoldable(root)
 1) If tree is empty then return true
 2) Else check if left and right subtrees are structure wise mirrors of
 each other. Use utility function IsFoldableUtil(root->left,
 root->right) for this.
 //Checks if n1 and n2 are mirror of each other.

 IsFoldableUtil(n1, n2)
 1) If both trees are empty then return true.
 2) If one of them is empty and other is not then return false.
 3) Return true if following conditions are met
 a) n1->left is mirror of n2->right
 b) n1->right is mirror of n2->left*/

public class FoldableBinaryTree {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		/* The constructed binary tree is
	        1
	      /   \
	     2     3
	      \    /
	       4  5
		 */
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.right.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("Is Mirror : " + isFoldable(tree.root));
	}

	public static boolean isFoldable(TreeNode root) {

		if (root == null)
			return true;

		return foldableUtil(root.left, root.right);
	}

	public static boolean foldableUtil(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null)
			return true;

		if (node1 == null || node2 == null)
			return false;

		return foldableUtil(node1.left, node2.right)
				&& foldableUtil(node1.right, node2.left);
	}

}
