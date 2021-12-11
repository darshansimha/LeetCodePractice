package Dec_05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		// Basically this problem wants us to show only the last child in each level
		// Which is the right side view of the tree
		// We do a level order traversal and only add the last child in queue into our
		// result

		// Using a queue to do my BFS
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		while (!queue.isEmpty()) {
			// We take a size variable because when we add the children to the queue the
			// size of the queue changes
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				// THis checks if this is the last element in the level
				if (i == size - 1) {
					result.add(current.val);
				}
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
		}

		return result;
	}
}
