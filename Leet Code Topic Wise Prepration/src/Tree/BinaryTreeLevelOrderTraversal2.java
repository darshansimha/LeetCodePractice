package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import Common.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int currentLevelSize = 1;
		TreeNode currentNode = new TreeNode();
		queue.add(root);
		Stack<List<Integer>> temp_result = new Stack<List<Integer>>();
		while (!queue.isEmpty()) {
			List<Integer> subList = new ArrayList<Integer>();
			currentLevelSize = queue.size();

			for (int i = 0; i < currentLevelSize; i++) {
				currentNode = queue.poll();
				subList.add(currentNode.val);
				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
			temp_result.push(subList);
		}
		while (!temp_result.isEmpty()) {
			result.add(temp_result.pop());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
