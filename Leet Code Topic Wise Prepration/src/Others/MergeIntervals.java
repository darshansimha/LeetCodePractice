package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		int start, end = 0;
		int istart, iend = 0;
		for (int i = 0; i < intervals.length; i++) {
			start = intervals[i][0];
			end = intervals[i][1];
			if (pq.isEmpty()) {
				pq.add(start);
				pq.add(end);
			} else {
				if (start <= pq.peek()) {
					if (end > pq.peek()) {
						pq.poll();
						pq.add(end);
					}
				} else {
					iend = pq.poll();
					istart = pq.poll();
					result.add(new ArrayList<Integer>(Arrays.asList(istart, iend)));
					pq.add(start);
					pq.add(end);
				}
			}
		}

		if (!pq.isEmpty()) {
			iend = pq.poll();
			istart = pq.poll();
			result.add(new ArrayList<Integer>(Arrays.asList(istart, iend)));
		}
		int[][] res = new int[result.size()][2];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = result.get(i).get(0);
			res[i][1] = result.get(i).get(1);
		}

		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals m = new MergeIntervals();
		int[] a1 = new int[] { 1, 4 };
		int[] a2 = new int[] { 4, 5 };
		int[] a3 = new int[] { 8, 10 };
		int[] a4 = new int[] { 15, 18 };

		int[][] k = new int[][] { a1, a2 };

		System.out.println(m.merge(k));
	}

}
