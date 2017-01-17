package part_03_tree;

/*Input Tree
A
/ \
B   C
/ \   \
D   E   F


Output Tree
A--->NULL
/ \
B-->C-->NULL
/ \   \
D-->E-->F-->NULL
*/
public class ConnectNodes {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
        
        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        
        connect(tree.root, true);
	}
	
	public static void connect(TreeNode node,boolean isRoot){
		if(node==null)
			return;
		if(isRoot)
			node.nextRight=null;
		
		if(node.left!=null){
			node.left.nextRight=node.right;
		}
		
		if(node.right!=null){
			node.right.nextRight=node.nextRight!=null?node.nextRight.left:null;
		}
		
		connect(node.left, false);
		connect(node.right, false);
	}

}
