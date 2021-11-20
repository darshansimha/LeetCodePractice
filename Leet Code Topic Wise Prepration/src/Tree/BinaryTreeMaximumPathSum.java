package Tree;

import Common.TreeNode;

public class BinaryTreeMaximumPathSum {
	public int result;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		result = root.val;
		dfs(root);
		return result;
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMax = Math.max(0, dfs(root.left));
		int rightMax = Math.max(0, dfs(root.right));
		// This is the case when we consider our current node in the path of the maximum
		// sum
		result = Math.max(result, rightMax + leftMax + root.val);
		// We return either the left max or the right max because we from the root we
		// would only like to traverse the path of the maximum sum
		return root.val + Math.max(leftMax, rightMax);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(-1);

		System.out.println(b.maxPathSum(root));
	}

}
