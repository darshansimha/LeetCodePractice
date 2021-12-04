package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Common.TreeNode;

public class BinaryTreeZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int currentLevelSize = 1;
		boolean leftToRight = true;
		TreeNode currentNode = new TreeNode();
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			currentLevelSize = queue.size();
			for (int i = 0; i < currentLevelSize; i++) {
				currentNode = queue.poll();
				if (leftToRight) {
					temp.add(currentNode.val);
				} else {
					temp.add(0, currentNode.val);
				}

				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
			result.add(temp);
			leftToRight = !leftToRight;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		BinaryTreeZigZagLevelOrderTraversal b = new BinaryTreeZigZagLevelOrderTraversal();
		System.out.println(b.zigzagLevelOrder(root));
	}

}
