package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
	public int maxLevelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int minLevel = 1;
		int maxSum = root.val;
		int currLevel = 1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int currLevelSum = 0;
		TreeNode marker = null;
		queue.add(marker);
		while (queue.size() > 1) {
			TreeNode temp = queue.poll();
			if (temp != marker) {
				currLevelSum += temp.val;
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			} else {
				if (currLevelSum > maxSum) {
					maxSum = currLevelSum;
					minLevel = currLevel;
				}
				currLevelSum = 0;
				currLevel++;
				queue.add(marker);
			}
		}
		if(currLevelSum > maxSum) {
			minLevel = currLevel;
		}
		
		return minLevel;
	}
}
