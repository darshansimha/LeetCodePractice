package Dec_08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	class Interval {
		int start;
		int end;

		Interval(int[] arr) {
			start = arr[0];
			end = arr[1];
		}
	}

	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return new int[0][2];
		}
		List<Interval> intervalList = new ArrayList<Interval>();
		for (int[] i : intervals) {
			intervalList.add(new Interval(i));
		}

		Collections.sort(intervalList, (a, b) -> a.start - b.start);
		Interval current = null;
		Interval previous = null;

		for (int i = 1; i < intervalList.size(); i++) {
			current = intervalList.get(i);
			previous = intervalList.get(i - 1);
			if (current.start <= previous.end) {
				current.start = previous.start;
				current.end = Math.max(previous.end, current.end);
				intervalList.set(i - 1, null);
			}
		}
		intervalList.removeAll(Collections.singleton(null));
		int[][] result = new int[intervalList.size()][2];
		for (int i = 0; i < intervalList.size(); i++) {
			result[i] = getArray(intervalList.get(i));
		}

		return result;
	}

	private int[] getArray(Interval i) {
		int[] result = new int[2];
		result[0] = i.start;
		result[1] = i.end;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
