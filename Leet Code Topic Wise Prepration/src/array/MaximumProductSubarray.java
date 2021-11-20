package array;

//https://leetcode.com/problems/maximum-product-subarray/submissions/
public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {
		int size = nums.length;

		int max = nums[0];
		int tempMax = nums[0];
		int min = nums[0];
		int result = nums[0];
		//Keep Track of Max until the index and min until index, max product can either be the number, the number * max until there
		// or the product of min and number (in case of negative numbers)
		for (int i = 1; i < size; i++) {
			tempMax = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
			min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
			max = tempMax;
			if (max > result) {
				result = max;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductSubarray m = new MaximumProductSubarray();
		System.out.println(m.maxProduct(new int[] { 2, 3, -2, 4 }));
	}

}
