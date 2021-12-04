package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class MaximumEarningsFromTaxi {
	public class Ride {
		int start;
		int end;
		int tip;

		Ride(int s, int e, int t) {
			this.start = s;
			this.end = e;
			this.tip = t;
		}
	}

	public long maxTaxiEarnings(int n, int[][] rides) {
		List<Ride> rideArr = new ArrayList<Ride>(n);
		for (int[] ride : rides) {
			rideArr.add(new Ride(ride[0], ride[1], ride[2]));
		}
		Collections.sort(rideArr, (a, b) -> {
			return a.end - b.end;
		});
		TreeMap<Integer, Long> map = new TreeMap<Integer, Long>();
		map.put(0, 0l);
		for (Ride r : rideArr) {
			long val = r.tip + (r.end - r.start) + map.floorEntry(r.start).getValue();
			if(val > map.lastEntry().getValue()) {
				map.put(r.end, val);
			}
		}
		return map.lastEntry().getValue();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
