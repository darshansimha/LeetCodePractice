package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber2 {
	public int rob(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int size = nums.length;
		if (size == 0) {
			return 0;
		}
		if (size == 1) {
			return nums[0];
		}
		if (size == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(robHelper(Arrays.copyOfRange(nums, 0, size - 1)), robHelper(Arrays.copyOfRange(nums, 1, size)));
	}
	public int robHelper(int[] nums) {
		if(nums == null) {
			return 0;
		}
		int size = nums.length;
		
		if(size == 1) {
			return nums[0];
		}
		if(size == 2) {
			return Math.max(nums[0], nums[1]);
		}
		
		int[] cache = new int[size];
		
		cache[0] = nums[0];
		cache[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < size; i++) {
			cache[i] = Math.max(nums[i] + cache[i - 2], cache[i - 1]);
		}
		
		return cache[size - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber2 h = new HouseRobber2();

		System.out.println(h.rob(new int[] { 1, 2, 1, 1 }));
	}

}
