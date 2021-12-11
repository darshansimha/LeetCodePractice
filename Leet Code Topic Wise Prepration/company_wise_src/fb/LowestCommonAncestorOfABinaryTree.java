package Dec_06;

import Dec_05.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || (p == null && q == null)) {
			return null;
		}
		if (p == null && q != null) {
			return q;
		}
		if (q == null && p != null) {
			return p;
		}

		if (p == root || q == root) {
			return root;
		}
		
		TreeNode left = null;
		TreeNode right = null;
		
		if(root.left != null) {
			//Searching in the left subtree
			left = lowestCommonAncestor(root.left, p, q);
		}
		if(root.right != null) {
			//Searching in the left subtree
			right = lowestCommonAncestor(root.right, p, q);
		}
		
		//If both are not null then both existed in the separate sides of the tree
		//i.e. that the root is the only thing that is common to them
		//Hence we return the root
		if(left != null && right != null) {
			return root;
		}
		//If it is found in either tree, the first node to be found is the LCA
		else if(left != null && right == null) {
			return left;
		} else {
			return right;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
