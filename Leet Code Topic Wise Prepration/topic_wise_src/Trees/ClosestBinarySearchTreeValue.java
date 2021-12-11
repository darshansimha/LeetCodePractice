package Dec_10;

import Dec_05.TreeNode;

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		int closest = root.val;
		while (root != null) {
			if (Math.abs(root.val - target) < Math.abs(closest - target)) {
				closest = root.val;
			}
			if (target < root.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return closest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
