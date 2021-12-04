package Trees;

import Common.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if(p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);

		root.right = new TreeNode(3);

		LowestCommonAncestorOfABinarySearchTree l = new LowestCommonAncestorOfABinarySearchTree();
		System.out.println(l.lowestCommonAncestor(root, root.right, root));
	}

}
