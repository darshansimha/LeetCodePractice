package Trees;

import Common.TreeNode;

public class SumOfLeftLeaves {
	int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		sum(root);
		
		return sum;
	}

	private void sum(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null && root.left.left == null && root.left.right == null) {
			sum += root.left.val;
		}
		sum(root.left);
		sum(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		SumOfLeftLeaves s = new SumOfLeftLeaves();
		System.out.println(s.sumOfLeftLeaves(root));
	}

}
