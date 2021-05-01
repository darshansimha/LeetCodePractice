package april29;

public class MinSubArraySumGtOrEqualToK {
	public int minSubArrayLen(int target, int[] nums) {
		int result = Integer.MAX_VALUE;
		
		int runningSum = 0;
		int right = 0, left = 0;
		for(right  = 0; right < nums.length; right++) {
			runningSum += nums[right];
			
			while(runningSum > target) {
				result = Math.min(result, (right - left));
				runningSum -= nums[left];
				++left;
			}
		}
		
		return result == Integer.MAX_VALUE ? 0 : result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinSubArraySumGtOrEqualToK m = new MinSubArraySumGtOrEqualToK();
		System.out.println(m.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
	}

}
