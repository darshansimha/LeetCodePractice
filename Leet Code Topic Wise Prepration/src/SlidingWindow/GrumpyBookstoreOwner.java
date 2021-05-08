package SlidingWindow;

public class GrumpyBookstoreOwner {

	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int sum = 0;
		int left = 0;
		int right = 0;

		int maxLoss = 0;
		int currentLoss = 0;

		int start = 0, end = 0;

		while (left < (customers.length - X) + 1) {
			currentLoss = currentLoss + (grumpy[right] * customers[right]);
			if ((right - left) + 1 == X) {
				if (currentLoss > maxLoss) {
					start = left;
					end = right;
					maxLoss = currentLoss;
				}
				currentLoss = 0;
				left += 1;
				right = left;
			} else {
				right++;
			}
		}
		for(int i = start; i <= end; i++) {
			grumpy[i] = 0;
		}
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0) {
				sum += customers[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrumpyBookstoreOwner g = new GrumpyBookstoreOwner();
		System.out
				.println(g.maxSatisfied(new int[] { 1, 0, 1, 2, 1, 1, 7, 5 }, new int[] { 0, 1, 0, 1, 0, 1, 0, 1 }, 3));
	}

}
