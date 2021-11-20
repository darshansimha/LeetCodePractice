package array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		if (nums.length == 1) {
			if (nums[0] == k) {
				return 1;
			} else {
				return 0;
			}
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// Base Case
		map.put(0, 1);
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}
}
