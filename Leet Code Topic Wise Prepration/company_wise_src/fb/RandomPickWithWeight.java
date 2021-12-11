package Dec_05;

public class RandomPickWithWeight {
	int[] prefixSums;
	int totalSum;

	public RandomPickWithWeight(int[] w) {
		prefixSums = new int[w.length];
		int prefixSum = 0;
		// With the prefix Sums we simulate converting the array for e.g.
		// [1,3] to [1,3,3,3]
		for (int i = 0; i < w.length; i++) {
			prefixSum += w[i];
			this.prefixSums[i] = prefixSum;
		}
		this.totalSum = prefixSum;
	}

	public int pickIndex() {
		// Random returns a value between 0 and 1 so when we multipy it by the total sum
		// We can make sure that the value will be in the bounds of the prefix sum array
		// Because 1 * total sum is equal to the last element in the prefix sum array
		double target = Math.random() * totalSum;
		// Now that we have the random number we need to see which prefix sum engulfs
		// the value.
		// i.e. we need to see if for e.g. rand = 0.5 then the target is let's assume 2
		// //from the [1,3] array
		// We need to see who covers the 2
		// Our prefix array is [1,4] which means 4 engulf's 2 and 4 is the 1st index of
		// the array
		int low = 0;
		int high = prefixSums.length;
		while (high > low) {
			int mid = low + ((high - low) / 2);
			// If the mid value is greater then we need to reduce our range and look inwards
			if (prefixSums[mid] > target) {
				high = mid;

			} // Other wise we need to expand our search and see if we find a bigger number
				// that our target lies within
			else {
				low = mid + 1;
			}
		}
		// We always return the low because we are not expecting to find the exact value
		// We need a number that is less than or equal to the target so that we know
		// that the number
		// Belongs to the range
		return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
