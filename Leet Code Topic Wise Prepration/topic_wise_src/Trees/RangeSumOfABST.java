package Dec_07;

import Dec_05.TreeNode;

public class RangeSumOfABST {
	int sum;

	public int rangeSumBST(TreeNode root, int low, int high) {
		sum = 0;
		rangeSumHelper(root, low, high);
		return sum;
	}

	public void rangeSumHelper(TreeNode root, int low, int high) {
		if (root == null) {
			return;
		}
		if (root.val < low) {
			rangeSumHelper(root.right, low, high);
		} else if (root.val > high) {
			rangeSumHelper(root.left, low, high);
		} else {
			sum += root.val;
			rangeSumHelper(root.right, low, high);
			rangeSumHelper(root.left, low, high);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
