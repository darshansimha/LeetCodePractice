package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Common.TreeNode;

public class KthSmallestElementInABST {

	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		return inorderTillK(root, k);
	}

	private int inorderTillK(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		List<TreeNode> list = new ArrayList<TreeNode>();
		while (!stack.isEmpty() || current != null) {
			if(list.size() == k) {
				return list.get(k - 1).val;
			}
			if(current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				list.add(current);
				current = current.right;
				
			}
		}
		return list.get(k - 1).val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(1);
//		root.left.right = new TreeNode(2);
//
//		root.right = new TreeNode(4);

		KthSmallestElementInABST k = new KthSmallestElementInABST();

		System.out.println(k.kthSmallest(root, 1));
	}

}
