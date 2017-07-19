package amazing;

import part_03_tree.TreeNode;

/**
 * Distance(X, Y) = Distance(root, X) + Distance(root, Y) — 2*Distance(root to
 * LCA(X,Y)) where LCA(X,Y) = Lowest Common Ancestor of X and Y
 */

public class DistanceBetweenTwoNodes {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(25);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(35);
		root.left.right.right = new TreeNode(45);
		System.out.println("Distance between 45 and 20 is : "
				+ findDistance(45, 20, root));

	}

	static int findDistance(int n1, int n2, TreeNode root) {
		if (root != null) {
			int distanceN1 = distance(n1, root) - 1;
			int distanceN2 = distance(n2, root) - 1;

			TreeNode lca = LCA(root, n1, n2);
			int distanceLCA = distance(lca.data, root) - 1;

			return (distanceN1 + distanceN2) - (2 * distanceLCA);

		}
		return 0;
	}

	static int distance(int n, TreeNode root) {
		if (root != null) {

			int x = 0;
			if (root.data == n || (x = distance(n, root.left)) > 0
					|| (x = distance(n, root.right)) > 0)
				return x + 1;

			return 0;
		}
		return 0;
	}

	/**
	 * 1.Start will the root. 2.If root>n1 and root>n2 then low­est com­mon
	 * ances­tor will be in left subtree. 3.If root<n1 and root<n2 then low­est
	 * com­mon ances­tor will be in right subtree. 4.If Step 2 and Step 3 is
	 * false then we are at the root which is low­est com­mon ances­tor, return
	 * it.
	 **/
	static TreeNode LCA(TreeNode node, int n1, int n2) {
		if (node == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (node.data > n1 && node.data > n2)
			return LCA(node.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (node.data < n1 && node.data < n2)
			return LCA(node.right, n1, n2);

		return node;
	}

}
