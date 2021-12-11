package Dec_07;

import Dec_05.TreeNode;

public class DiameterOfABinaryTree {
	int max;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		max = 1;
		diameterHelper(root);
		return max;
	}

	private int diameterHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = diameterHelper(root.left);
		int right = diameterHelper(root.right);

		max = Math.max(max, left + right);

		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
