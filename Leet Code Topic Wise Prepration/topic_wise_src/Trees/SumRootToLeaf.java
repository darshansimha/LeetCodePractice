package Trees;

import Common.TreeNode;

public class SumRootToLeaf {
	int rootToLeaf = 0;

	public int sumNumbers(TreeNode root) {
		preorder(root, 0);
		return rootToLeaf;
	}

	public void preorder(TreeNode r, int currNumber) {
		if (r != null) {
			currNumber = currNumber * 10 + r.val;
			// if it's a leaf, update root-to-leaf sum
			if (r.left == null && r.right == null) {
				rootToLeaf += currNumber;
			}
			preorder(r.left, currNumber);
			preorder(r.right, currNumber);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		SumRootToLeaf s = new SumRootToLeaf();
		System.out.println(s.sumNumbers(root));
	}

}
