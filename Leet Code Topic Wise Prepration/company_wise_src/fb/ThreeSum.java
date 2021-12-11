package Dec_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		//We sort this to make our problem similar to two sum 2 
		//Where we can use the two pointer approach rather than the hashmap approach
		//Which not only uses extra memory but also needs you to take care of the index 
		//Not being reused
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				twoSum(nums, i, result);
			}
		}
		return result;
	}

	private void twoSum(int[] nums, int current, List<List<Integer>> result) {
		//The reason left starts from current and not 0 is because the array is sorted
		//If you start from zero then you might use the current index twice again 
		//Also you might get duplicates because those numbers would have already been iterated in the previous indexes
		int left = current + 1;
		int right = nums.length - 1;

		int curr = 0;

		while (right > left) {
			curr = nums[current] + nums[left] + nums[right];
			if (curr < 0) {
				left++;
			} else if (curr > 0) {
				right--;
			} else {
				result.add(Arrays.asList(nums[current], nums[left], nums[right]));
				//regardless of finding the solution, we still need to persevere so that we can
				//find all the solutions
				left++;
				right--;
				// We do this to avoid duplicates
				//To do this we need to advance our right pointer until it is not equal to the number before it
				while(left < right && nums[left] == nums[left - 1]) {
					left++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(new int[] { -2, 0, 0, 2, 2 }));
	}

}
