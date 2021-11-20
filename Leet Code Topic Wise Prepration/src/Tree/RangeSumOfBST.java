package Tree;

import Common.TreeNode;

public class RangeSumOfBST {
	int sum = 0;

	public int rangeSumBST(TreeNode root, int low, int high) {
		helper(root, low, high);
		return sum;
	}

	private void helper(TreeNode root, int low, int high) {
		if (root == null) {
			return;
		}
		if (root.val >= low && root.val <= high) {
			sum += root.val;
		}

		if (root.val > low) {
			helper(root.left, low, high);
		}
		if (root.val < high) {
			helper(root.right, low, high);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);

		root.right.right = new TreeNode(18);

		root.left.left.left = new TreeNode(1);
		root.left.right.left = new TreeNode(6);

		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(18);

		RangeSumOfBST r = new RangeSumOfBST();
		System.out.println(r.rangeSumBST(root, 6, 10));
	}

}
