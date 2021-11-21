package Trees.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Common.TreeNode;

//left -> right -> root
public class PostOrderTraversalRecursive {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		postOrderHelper(root, result);
		return result;
	}
	private void postOrderHelper(TreeNode root,List<Integer> result ) {
		if (root == null) {
			return;
		}
		postOrderHelper(root.left, result);
		postOrderHelper(root.right, result);
		result.add(root.val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.left.right = new TreeNode(5);

		root.right = new TreeNode(6);
		root.right.left = new TreeNode(7);
		
		PostOrderTraversalRecursive p = new PostOrderTraversalRecursive();
		System.out.println(p.postorderTraversal(root));
	}

}
