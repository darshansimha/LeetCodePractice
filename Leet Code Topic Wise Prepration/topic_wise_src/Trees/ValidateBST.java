package Trees;

import Common.TreeNode;

public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, null, null);
	}

	private boolean isValidBSTHelper(TreeNode root, Integer left, Integer right) {
		if(root == null) {
			return true;
		}
		if(left != null && root.val >= left || right != null && root.val <= right) {
			return false;
		} else {
			return isValidBSTHelper(root.left, root.val, right) && isValidBSTHelper(root.right, left, root.val);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(1);
		ValidateBST v = new ValidateBST();
		System.out.println(v.isValidBST(root));
	}

}
