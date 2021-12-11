package Dec_05;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		int len = nums.length;
		// This is a map with key as the prefix Sum
		// Value as the number of times we have seen this prefix sum in the past
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// This is to handle the case when our prefix Sum becomes equal to k
		map.put(0, 1);
		int result = 0;
		int currentSum = 0;
		for (int i = 0; i < len; i++) {
			currentSum += nums[i];
			// Note : We don't have to look for the case where nums[i] == k
			// Because when we subtract current sum from k we get the case where we subtract
			// the whole array
			// Before our element which covers the case
			if (map.containsKey(currentSum - k)) {
				result += map.get(currentSum - k);
			}
			// When ever we see the sum again we update it's count
			map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubArraySumEqualsK s = new SubArraySumEqualsK();
		System.out.println(s.subarraySum(new int[] { 1, 1, 1 }, 2));
	}

}
