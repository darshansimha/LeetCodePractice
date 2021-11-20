package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Common.TreeNode;

public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}
		if (root == null || subRoot == null) {
			return false;
		}
		List<Integer> inorderRoot = new ArrayList<>();
		List<Integer> inorderSubRoot = new ArrayList<>();
		List<Integer> preOrderSubRoot = new ArrayList<>();
		List<Integer> preOrderRoot = new ArrayList<>();

		inorderTraversal(root, inorderRoot);
		inorderTraversal(subRoot, inorderSubRoot);

		preOrderTraversal(root, preOrderRoot);
		preOrderTraversal(subRoot, preOrderSubRoot);

		if (buildString(preOrderRoot).indexOf(buildString(preOrderSubRoot)) >= 0
				&& buildString(inorderRoot).indexOf(buildString(inorderSubRoot)) >= 0) {
			return true;
		}
		return false;
	}

	private void inorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			result.add(null);
			return;
		}
		inorderTraversal(root.left, result);
		result.add(root.val);
		inorderTraversal(root.right, result);

	}

	private void preOrderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			result.add(null);
			return;
		}
		result.add(root.val);
		preOrderTraversal(root.left, result);
		preOrderTraversal(root.right, result);
	}

	private String buildString(List<Integer> a) {
		StringBuilder sb = new StringBuilder();
		for (Integer i : a) {
			sb.append(String.valueOf(i) + ",");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(0);

		TreeNode sub = new TreeNode(4);
		sub.left = new TreeNode(1);
		sub.right = new TreeNode(2);

		SubtreeOfAnotherTree s = new SubtreeOfAnotherTree();

		System.out.println(s.isSubtree(root, sub));
	}

}
