package Dec_10;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import Dec_05.TreeNode;

public class ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		if (root == null || k <= 0) {
			return new ArrayList<Integer>(0);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> {
			if (Math.abs(a - target) > Math.abs(b - target)) {
				return -1;
			} else if (Math.abs(a - target) == Math.abs(b - target)) {
				return 0;
			} else {
				return 1;
			}
		});
		inorderTraversal(root, k, pq);

		return new ArrayList<Integer>(pq);
	}

	private void inorderTraversal(TreeNode root, int k, PriorityQueue<Integer> pq) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, k, pq);
		pq.add(root.val);
		if (pq.size() > k) {
			pq.poll();
		}
		inorderTraversal(root.right, k, pq);
	}
}
