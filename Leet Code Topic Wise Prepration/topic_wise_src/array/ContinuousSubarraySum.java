package array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;
		Map<Integer, Integer> remaindersAtIndexMap = new HashMap<Integer, Integer>();
		remaindersAtIndexMap.put(0, -1);
		int remainder = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			remainder = sum % k;
			if (remaindersAtIndexMap.containsKey(remainder) && i - remaindersAtIndexMap.get(remainder) > 1) {
				return true;
			} else if(!remaindersAtIndexMap.containsKey(remainder)){
				remaindersAtIndexMap.put(remainder, i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
