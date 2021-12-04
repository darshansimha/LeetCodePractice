package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSumHelper(candidates, target, result, new ArrayList<Integer>(), new HashSet<String>());
		return result;
	}

	public void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> current,
			Set<String> unique) {
		if (target == 0) {
			Collections.sort(current);
			if (!unique.contains(current.toString())) {
				unique.add(current.toString());
				result.add(current);
			}
			return;
		}
		for (int i : candidates) {
			if (i <= target) {
				current.add(i);
				combinationSumHelper(candidates, target - i, result, new ArrayList<>(current), unique);
				current.remove(current.size() - 1);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum c = new CombinationSum();
		System.out.println(c.combinationSum(new int[] { 2, 3, 5 }, 8));
	}
}
