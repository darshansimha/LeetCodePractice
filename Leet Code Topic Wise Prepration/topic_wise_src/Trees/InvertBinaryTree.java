package Trees;

import Common.TreeNode;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		invertHelper(root);
		return root;
	}

	private void invertHelper(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertHelper(root.left);
		invertHelper(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
