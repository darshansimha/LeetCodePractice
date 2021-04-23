package april19;

import java.util.List;
import java.util.Stack;

public class KthSmallestElementOfBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		int result = 0;
		while(true) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			result = stack.pop().val;
			k--;
			
			if(k == 0) {
				return result;
			}
			root = root.right;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
