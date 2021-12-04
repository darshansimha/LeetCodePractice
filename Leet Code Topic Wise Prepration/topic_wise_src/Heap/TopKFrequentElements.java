package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> map.get(b) - map.get(a));

		for (int i : map.keySet()) {
			heap.add(i);
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = heap.poll();
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentElements t = new TopKFrequentElements();
		System.out.println(Arrays.asList(t.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
	}

}
