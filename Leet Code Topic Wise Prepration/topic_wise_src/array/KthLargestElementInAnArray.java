package array;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return -1;
		}
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
		for (int i = 0; i < nums.length; i++) {
			if(heap.size() < k) {
				heap.add(nums[i]);
			} else {
				if(nums[i] > heap.peek()) {
					heap.poll();
					heap.add(nums[i]);
				}
			}
		}

		return heap.poll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
