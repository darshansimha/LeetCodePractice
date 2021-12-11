package Dec_05;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return false;
		}
		int currSum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			currSum += nums[i];
			if (currSum%k == 0) {
				if (i >= 1) {
					return true;
				}
			} else {
				if (map.containsKey(currSum % k) && Math.abs(i - map.get(currSum % k)) > 1) {
					return true;
				}
			}
			map.putIfAbsent(currSum % k, i);
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContinuousSubarraySum c = new ContinuousSubarraySum();
		System.out.println(c.checkSubarraySum(new int[] { 5, 0, 0, 0 }, 3));
	}

}
