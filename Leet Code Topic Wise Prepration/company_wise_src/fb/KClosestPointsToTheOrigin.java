package Dec_05;

import java.util.PriorityQueue;

public class KClosestPointsToTheOrigin {
	class Points {
		int x;
		int y;

		Points(int _x, int _y) {
			x = _x;
			y = _y;
		}

		@Override
		public String toString() {
			return "x : " + x + " y : " + y;
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		int[][] result = new int[k][2];
		if(k <= 0 || points == null) {
			return null;
		}
		if(k == points.length) {
			return points;
		}
		//Create a Max Heap because we'd always want the max element to stay on top
		//So that we can eliminate it for a closer point in the future.
		PriorityQueue<Points> pq = new PriorityQueue<Points>((a, b) -> {
			double _a = calculateDistance(a);
			double _b = calculateDistance(b);
			if (_b > _a) {
				return 1;
			} else if (_b < _a) {
				return -1;
			} else {
				return 0;
			}
		});
		
		for (int[] point : points) {
			//If the heap is at capacity then we knock the fartherst point out of our heap and add the new one
			if (pq.size() == k) {
				Points temp = new Points(point[0], point[1]);
				if (calculateDistance(temp) < calculateDistance(pq.peek())) {
					pq.poll();
					pq.add(temp);
				}
			} else {
				pq.add(new Points(point[0], point[1]));
			}
		}
		int idx = 0;
		while (!pq.isEmpty()) {
			Points temp = pq.poll();
			result[idx] = new int[] { temp.x, temp.y };
			idx++;
		}

		return result;
	}

	private double calculateDistance(Points a) {
		return Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KClosestPointsToTheOrigin k = new KClosestPointsToTheOrigin();
		System.out.println(k.kClosest(new int[][] { { -5, 4 }, { -6, -5 }, { 4, 6 } }, 2));
	}

}
