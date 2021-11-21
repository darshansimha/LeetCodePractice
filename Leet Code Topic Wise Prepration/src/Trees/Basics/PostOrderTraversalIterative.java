package Trees.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Common.TreeNode;

public class PostOrderTraversalIterative {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		TreeNode curr = root;
		while (!s1.isEmpty()) {
			curr = s1.pop();
			s2.push(curr);
			if(curr.left != null) {
				s1.push(curr.left);
			}
			if(curr.right != null) {
				s1.push(curr.right);
			}
		}
		while(!s2.isEmpty()) {
			result.add(s2.pop().val);
		}
		return result;
	}
}
