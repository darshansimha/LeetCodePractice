package array;

//https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(target - nums[i])) {
        		result[0] = i;
        		result[1] = map.get(target - nums[i]);
        		return result;
        	}
        	map.put(nums[i], i);
        }
        
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum t = new TwoSum();
		System.out.println(Arrays.toString(t.twoSum(new int[] {3,3,4,2}, 6)));
	}

}
