package DynamicProgramming;

public class IncreasingTripletSubsequence {
	
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length < 3) {
			return false;
		}

		boolean result = false;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int currentMax = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					currentMax  = Math.max(currentMax, dp[j]);
				}
				
			}
			dp[i] = currentMax + 1;
			if(dp[i] == 3) {
				return true;
			}
		}

		return result;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
