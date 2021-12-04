package DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> temp = new HashSet<>();
		//Arrays.sort(nums);
		subsetsWithDupRec(temp, nums, new ArrayList<Integer>(), 0);
		for (List<Integer> i : temp) {
			result.add(i);
		}
		return result;
	}

	public void subsetsWithDupRec(Set<List<Integer>> result, int[] nums, List<Integer> current, int index) {
		result.add(new ArrayList<>(current));

		for (int i = index; i < nums.length; i++) {
			current.add(nums[i]);
			subsetsWithDupRec(result, nums, current, i + 1);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets2 s = new Subsets2();

		System.out.println(s.subsetsWithDup(new int[] { 1, 2, 2 }));
	}

}
