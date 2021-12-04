package array;
//https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0 || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			// Since the array is sorted all duplicates will be adjacent to each other
			if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
				int left = i + 1;
				int right = nums.length - 1;
				int threeSum = 0;
				while (left < right) {
					threeSum = nums[i] + nums[left] + nums[right];
					// Since the array is sorted we can move the pointers inward until we reach the
					// target
					// If current sum is greater than zero we need to reduce the sum so we move the
					// right pointer inward and vice versa
					if (threeSum == 0) {
						result.add(Arrays.asList(nums[i], nums[left], nums[right]));
						left++;
						// We need to move the pointer to the next element who is not same as the
						// element we just processed
						// This ensures that we do not do any duplicate processing, therby avoiding
						// duplicates in the result set
						while (nums[left] == nums[left - 1] && left < right) {
							left++;
						}
					} else if (threeSum > 0) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(new int[] { -4, -1, -1, 0, 1, 2 }));
	}

}
