package Dec_08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
	class Interval {
		int start;
		int end;

		Interval(int[] arr) {
			start = arr[0];
			end = arr[1];
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		if ((intervals == null || intervals.length == 0) && newInterval == null) {
			return null;
		} else if (intervals.length == 0 && newInterval != null) {
			return new int[][] { newInterval };
		}
		List<Interval> intervalList = new ArrayList<Interval>();
		for (int[] i : intervals) {
			intervalList.add(new Interval(i));
		}

		int insertIndex = binarySearch(intervalList, 0, intervalList.size() - 1, newInterval[0]);
		Interval toMerge = new Interval(newInterval);

		if (toMerge.start > intervalList.get(insertIndex).start) {
			insertIndex += 1;
		}
		intervalList.add(insertIndex, toMerge);
		mergeIntervals(intervalList);

		int[][] result = new int[intervalList.size()][2];
		for (int i = 0; i < intervalList.size(); i++) {
			result[i] = getArray(intervalList.get(i));
		}

		return result;
	}

	private void mergeIntervals(List<Interval> intervalList) {
		Interval current = null;
		Interval previous = null;

		for (int i = 1; i < intervalList.size(); i++) {
			current = intervalList.get(i);
			previous = intervalList.get(i - 1);
			if (current.start <= previous.end) {
				current.start = Math.min(previous.start, current.start);
				current.end = Math.max(previous.end, current.end);
				intervalList.set(i - 1, null);
			}
		}
		intervalList.removeAll(Collections.singleton(null));
	}

	public int binarySearch(List<Interval> list, int low, int high, int targetStart) {
		while (high > low) {
			int mid = low + (high - low) / 2;
			if (list.get(mid).start > targetStart) {
				high = mid - 1;
			} else if (list.get(mid).start < targetStart) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}

	private int[] getArray(Interval i) {
		int[] result = new int[2];
		result[0] = i.start;
		result[1] = i.end;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertInterval i = new InsertInterval();

		System.out.println(i.insert(new int[][] { { 1, 5 } }, new int[] { 6, 8 }));
	}

}
