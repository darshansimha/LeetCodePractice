package Trees;

import Common.TreeNode;

public class ClosestValueToATargetInABST {
	public int closestValue(TreeNode root, double target) {
		int val, closest = root.val;
		while (root != null) {
			val = root.val;
			closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
			root = target < root.val ? root.left : root.right;
		}
		return closest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
