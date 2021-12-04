package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		permuteRec(result, nums, new ArrayList<Integer>(), visited);
		return result;
	}

	public void permuteRec(List<List<Integer>> result, int[] nums, List<Integer> current, boolean[] visited) {
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
			permuteRec(result, nums, current, visited);
			visited[i] = false;
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[] { 1, 2, 3 }));
	}

}
