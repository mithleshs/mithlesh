package part_03_tree;

public class MaxWidthOfTree {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		int maxWidth=0;
        
        /*
        Constructed bunary tree is:
              1
            /  \
           2    3
         /  \    \
        4   5     8 
                 /  \
                6   7
         */
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(8);
        tree.root.right.right.left = new TreeNode(6);
        tree.root.right.right.right = new TreeNode(7);
  
		int height = tree.height(tree.root);

		for (int i = 1; i <= height; i++) {
			int levelWidth = getWidth(tree.root, i);
			if (levelWidth > maxWidth) {
				maxWidth = levelWidth;
			}
			System.out.println("Width at level " + i + " is : " + levelWidth);
		}

		System.out.println("Maximum width is " + maxWidth);
	}

	public static int getWidth(TreeNode node, int level) {

		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1) {
			return getWidth(node.left, level - 1)
					+ getWidth(node.right, level - 1);
		}
		return 0;
	}

}
