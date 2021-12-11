package Dec_07;

import Dec_05.TreeNode;

public class BinaryTreeeMaximumPathSum {
	int maxSum;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxSum = Integer.MIN_VALUE;
		maxPathSumHelper(root);
		
		return maxSum;
	}

	private int maxPathSumHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(maxPathSumHelper(root.left), 0);
		int right =  Math.max(maxPathSumHelper(root.right), 0);

		maxSum = Math.max(maxSum, Math.max(root.val + left + right, root.val + Math.max(left, right)));
		return root.val + Math.max(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
