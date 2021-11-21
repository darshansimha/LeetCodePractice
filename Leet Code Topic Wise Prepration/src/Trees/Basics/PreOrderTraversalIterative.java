package Trees.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Common.TreeNode;
//Root -> Left -> Right
public class PreOrderTraversalIterative {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		stack.push(root);

		while (!stack.isEmpty()) {
			curr = stack.pop();
			result.add(curr.val);
			//Right is added before left because we are using a stack
			//i.e. we need to process left before right so the reversal of the order
			if (curr.right != null) {
				stack.add(curr.right);
			}
			if (curr.left != null) {
				stack.add(curr.left);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.left.right = new TreeNode(5);

		root.right = new TreeNode(6);
		root.right.left = new TreeNode(7);
		PreOrderTraversalIterative p = new PreOrderTraversalIterative();
		System.out.println(p.preorderTraversal(root));
	}
}
