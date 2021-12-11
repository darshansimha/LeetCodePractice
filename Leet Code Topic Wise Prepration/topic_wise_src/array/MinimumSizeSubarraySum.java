package sliding_window;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int len = nums.length;
		int minSize = len + 1;
		int sum = 0;
		for (int right = 0; right < len; right++) {
			sum = sum + nums[right];
			while (sum >= target) {
				minSize = Math.min(minSize, (right - left) + 1);
				sum -= nums[left];
				left++;
			}
		}
		return minSize == len + 1 ? 0 : minSize;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
