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

	// This function returns pointer to LCA of two given
	// values n1 and n2.
	// v1 is set as true by this function if n1 is found
	// v2 is set as true by this function if n2 is found

	static boolean v1 = false, v2 = false;

	static TreeNode findLCAUtil(TreeNode node, int n1, int n2) {
		// Base case
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report the presence
		// by setting v1 or v2 as true and return root (Note that if a key
		// is ancestor of other, then the ancestor key becomes LCA)
		if (node.data == n1) {
			v1 = true;
			return node;
		}
		if (node.data == n2) {
			v2 = true;
			return node;
		}

		// Look for keys in left and right subtrees
		TreeNode left_lca = findLCAUtil(node.left, n1, n2);
		TreeNode right_lca = findLCAUtil(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	// Finds lca of n1 and n2 under the subtree rooted with 'node'
	static TreeNode findLCA(TreeNode root, int n1, int n2) {
		// Initialize n1 and n2 as not visited
		v1 = false;
		v2 = false;

		// Find lca of n1 and n2 using the technique discussed above
		TreeNode lca = findLCAUtil(root, n1, n2);

		// Return LCA only if both n1 and n2 are present in tree
		if (v1 && v2)
			return lca;

		// Else return NULL
		return null;
	}

}
