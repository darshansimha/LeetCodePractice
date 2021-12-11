package Dec_07;

import java.util.Stack;

import Dec_05.TreeNode;

class BSTIterator {
	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		moveLeft(root);
	}

	public int next() {
		TreeNode node = stack.pop();
		stack.push(node.right);
		return node.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void moveLeft(TreeNode root) {
		if (root != null) {
			stack.push(root);
			moveLeft(root.left);
		} else {
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
