package DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		Set<List<Integer>> tempResult = new HashSet<>();
		permuteUniqueRec(tempResult, nums, new ArrayList<Integer>(), visited);
		for(List<Integer> i : tempResult) {
			result.add(i);
		}
		return result;
	}

	public void permuteUniqueRec(Set<List<Integer>> result, int[] nums, List<Integer> current, boolean[] visited) {
		if (current.size() == nums.length) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			current.add(nums[i]);
			visited[i] = true;
			permuteUniqueRec(result, nums, current, visited);
			visited[i] = false;
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations2 p = new Permutations2();
		System.out.println(p.permuteUnique(new int[] { 1, 2, 3 }));
	}

}
