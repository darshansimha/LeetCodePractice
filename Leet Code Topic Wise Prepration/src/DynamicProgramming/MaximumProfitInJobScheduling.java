package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
	class Job {
		int startTime;
		int endTime;
		int profit;

		Job(int s, int e, int p) {
			this.startTime = s;
			this.endTime = e;
			this.profit = p;
		}

		@Override
		public String toString() {
			return "Start : " + startTime + " End Time : " + endTime + " Profit : " + profit;
		}
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		List<Job> jobs = new ArrayList<MaximumProfitInJobScheduling.Job>();
		for (int i = 0; i < startTime.length; i++) {
			jobs.add(new Job(startTime[i], endTime[i], profit[i]));
		}
		Collections.sort(jobs, (a, b) -> {
			return a.endTime - b.endTime;
		});
		TreeMap<Integer, Integer> dp = new TreeMap<Integer, Integer>();
		dp.put(0, 0);
		for (Job job : jobs) {
			// Select the job
			int val = job.profit + dp.floorEntry(job.startTime).getValue();
			if (val > dp.lastEntry().getValue()) {
				dp.put(job.endTime, val);
			}
		}

		return dp.lastEntry().getValue();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProfitInJobScheduling m = new MaximumProfitInJobScheduling();
		System.out.println(m.jobScheduling(new int[] { 1, 2, 3, 4, 6 }, new int[] { 3, 5, 10, 6, 9 },
				new int[] { 20, 20, 100, 70, 60 }));
	}

}
