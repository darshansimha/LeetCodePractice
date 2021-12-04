package Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		if (intervals.length == 1) {
			return 1;
		}
		// Sort by start time
		Arrays.sort(intervals, (a, b) -> {
			return a[0] - b[0];
		});
		// Min heap of End Times
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

		minHeap.add(intervals[0][1]);
		// If the room due to free up the earliest is free, assign that room to this meeting.
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] >= minHeap.peek()) {
				minHeap.poll();
			}
			minHeap.add(intervals[i][1]);
		}
		return minHeap.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
