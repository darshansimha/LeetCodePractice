package SlidingWindow;

import java.util.Arrays;

public class SumArraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		int result = 0;

		Arrays.sort(nums);

		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}

		int low = 0;
		int high = low + 1;
		int currSum = sum[high];

		while(high > low) {
			if(currSum == k) {
				result++;
				low = high;
				high = low + 1;
			} else if(currSum < k) {

			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

