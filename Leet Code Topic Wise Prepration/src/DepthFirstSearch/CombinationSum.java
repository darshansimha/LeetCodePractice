package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSumRec(result, candidates, target, 0, new ArrayList<Integer>());

		return result;
	}

	public void combinationSumRec(List<List<Integer>> result, int[] nums, int target, int index,
			List<Integer> current) {
		if (index == nums.length) {
			if (target == 0) {
				List<Integer> t = new ArrayList<Integer>(current);
				result.add(t);
			}
			return;
		}
		if (nums[index] <= target) {
			current.add(nums[index]);
			combinationSumRec(result, nums, target - nums[index], index, current);
			current.remove(current.size() - 1);
		}
		combinationSumRec(result, nums, target, index + 1, current);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum c = new CombinationSum();

		System.out.println(c.combinationSum(new int[] { 2, 1, 6, 7 }, 7));
	}

}
