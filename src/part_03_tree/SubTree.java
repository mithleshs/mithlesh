package part_03_tree;

/*Following are detailed steps.
1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].
2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].
3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.
*/
public class SubTree {

	public static void main(String[] args) {
		
		// TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
		
		BinaryTree tree1 = new BinaryTree();   
		tree1.root = new TreeNode(26);
		tree1.root.right = new TreeNode(3);
		tree1.root.right.right = new TreeNode(3);
		tree1.root.left = new TreeNode(10);
		tree1.root.left.left = new TreeNode(4);
		tree1.root.left.left.right = new TreeNode(30);
		tree1.root.left.right = new TreeNode(6);
        
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
		BinaryTree tree2 = new BinaryTree();      
		tree2.root = new TreeNode(10);
		tree2.root.right = new TreeNode(6);
		tree2.root.left = new TreeNode(4);
		tree2.root.left.right = new TreeNode(30);

		System.out.println("tree2 is subtree of tree1 : "+isSubTree(tree1, tree2));
		
		
	}
	
	public static boolean isSubTree(BinaryTree T,BinaryTree S){
		
		if(S.root==null)
			return true;
		if(T.root==null)
			return false;
		
		System.out.println("PRE-ORDER");
		T.preorder(T.root);
		System.out.println("");
		
		System.out.println("IN-ORDER");
		T.inorder(T.root);
		System.out.println("");
		
		int[] preT=T.preOrder;
		int[] inT=T.inOrder;
		
		System.out.println("PRE-ORDER");
		S.preorder(S.root);
		System.out.println("");
		
		System.out.println("IN-ORDER");
		S.inorder(S.root);
		System.out.println("");
		
		int[] preS=S.preOrder;
		int[] inS=S.inOrder;
		
		return isSubArray(inS, inT,S.inOrderIn,T.inOrderIn) && isSubArray(preS, preT,S.preOrderIn,T.preOrderIn);
	}
	
	public static boolean isSubArray(int[] subA, int[] fullA,int subLength,int fullLength) {
		boolean isSub = false;
		if (subLength > fullLength)
			return false;

		for (int i = 0; i < fullLength; i++) {
			if (fullA[i] == subA[0]) {
				isSub = true;
				for (int j = 1; j < subLength; j++) {
					if (i + j < fullLength && subA[j] == fullA[i + j]) {
						isSub = true;
					} else {
						isSub = false;
						break;
					}
				}
				break;
			}
		}
		return isSub;
	}

}
