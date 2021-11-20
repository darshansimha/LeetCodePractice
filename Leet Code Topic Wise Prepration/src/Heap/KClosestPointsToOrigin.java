package Heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int k) {
		if (k <= 0 || points == null) {
			return null;
		}
		// Max heap of k points
		PriorityQueue<List<Integer>> heap = new PriorityQueue<List<Integer>>(k,
				(a, b) -> distanceToOrigin(b) - distanceToOrigin(a));

		for (int i = 0; i < points.length; i++) {
			if (heap.size() < k) {
				heap.add(Arrays.asList(points[i][0], points[i][1]));
			} else {
				if (distanceToOrigin(heap.peek()) > distanceToOrigin(Arrays.asList(points[i][0], points[i][1]))) {
					heap.poll();
					heap.add(Arrays.asList(points[i][0], points[i][1]));
				}
			}

		}
		int[][] result = new int[k][2];
		int i = 0;
		while (!heap.isEmpty()) {
			List<Integer> curr = heap.poll();
			result[i] = new int[] { curr.get(0), curr.get(1) };
			i++;
		}
		return result;
	}

	private int distanceToOrigin(List<Integer> a) {
		return a.get(0) * a.get(0) + a.get(1) * a.get(1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KClosestPointsToOrigin k = new KClosestPointsToOrigin();
		System.out.println(Arrays.asList(k.kClosest(new int[][] { { -5, 4 }, { -6, -5 }, { 4, 6 } }, 2)));
	}

}
