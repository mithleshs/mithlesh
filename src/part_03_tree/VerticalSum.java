package part_03_tree;

import java.util.HashMap;
import java.util.Map;

/*Solution:
	We need to check the Horizontal Distances from root for all nodes. 
	If two nodes have the same Horizontal Distance (HD), then they are on same vertical line. 
	The idea of HD is simple. HD for root is 0, a right edge (edge connecting to right subtree) is 
	considered as +1 horizontal distance and a left edge is considered as -1 horizontal distance. 
	For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 
	and HD for node 7 is +2.
	We can do inorder traversal of the given Binary Tree. 
	While traversing the tree, we can recursively calculate HDs. 
	We initially pass the horizontal distance as 0 for root. 
	For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. 
	For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1.
*/
public class VerticalSum {

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		/* Create following Binary Tree
		        1
		      /    \
		    2        3
		   / \      / \
		  4   5    6   7
		
		*/
		
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		
		verticalSum(tree.root, 0);
		
		System.out.println(map.entrySet());
		int verticalLineCount=1;
		
		for(int i=-4;i<10;i++){
			if(map.containsKey(i)){
				System.out.println("Sum of Vertical Line "+verticalLineCount+" is : "+map.get(i));
				verticalLineCount++;
			}
		}
	}

	public static void verticalSum(TreeNode node, int horiDistance) {

		if (node == null)
			return;

		verticalSum(node.left, horiDistance - 1);

		int prevSum = 0;
		if (map.containsKey(horiDistance)) {
			prevSum = map.get(horiDistance);
		}
		prevSum = prevSum + node.data;

		map.put(horiDistance, prevSum);

		verticalSum(node.right, horiDistance + 1);
	}
}
