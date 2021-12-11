package Dec_05;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return -1;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);

		for (int i : nums) {
			if (minHeap.size() == k) {
				if (i > minHeap.peek()) {
					minHeap.poll();
					minHeap.add(i);
				}
			} else {
				minHeap.add(i);
			}
		}
		
		return minHeap.poll();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
