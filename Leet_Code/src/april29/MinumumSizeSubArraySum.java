package april29;

import java.util.stream.IntStream;

public class MinumumSizeSubArraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int result = Integer.MAX_VALUE;
		int size = nums.length;
		if(IntStream.of(nums).allMatch(x -> x == target)) {
			return 1;
		}
		int[] sum = new int[size];
		int[] revSum = new int[size];
		int currSum = 0;
		for(int i = 0; i < size; i++) {
			currSum += nums[i];
			sum[i] = currSum;
			if(sum[i] >= target) {
				result =  Math.min(i + 1, result);
			}
		}
		currSum = 0;
		
		for(int i = size - 1; i >= 0; i--) {
			currSum += nums[i];
			revSum[i] = currSum;
			if(revSum[i] >= target) {
				result = Math.min(size - i, result);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinumumSizeSubArraySum m = new MinumumSizeSubArraySum();
		System.out.println(m.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
	}

}
