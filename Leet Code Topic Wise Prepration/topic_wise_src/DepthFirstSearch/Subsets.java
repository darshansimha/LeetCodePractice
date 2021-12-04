package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return subsets;
		}
		subsetsRec(subsets, nums, new ArrayList<Integer>(), 0);
		return subsets;
	}

	public void subsetsRec(List<List<Integer>> result, int[] nums, List<Integer> current, int index) {
		result.add(new ArrayList<Integer>(current));
		
		for(int i = index; i < nums.length; i++) {
			current.add(nums[i]);
			subsetsRec(result, nums, current, i + 1);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets s = new Subsets();
		System.out.println(s.subsets(new int[] { 1, 2, 3 }));
	}

}
