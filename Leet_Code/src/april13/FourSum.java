package april13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, LinkedList<String>> map = new HashMap<Integer, LinkedList<String>>();

		int currSum = 0;
		LinkedList<String> curr = new LinkedList<String>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				currSum = nums[i] + nums[j];
				if (map.containsKey(currSum)) {
					curr = map.get(currSum);
					curr.add(i + "," + j);
					map.put(currSum, curr);
				} else {
					curr = new LinkedList<String>();
					curr.add(i + "," + j);
					map.put(currSum, curr);
				}
			}
		}

		currSum = 0;

		Set<ArrayList<Integer>> unique = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				currSum = nums[i] + nums[j];
				if (map.containsKey(target - currSum)) {
					curr = map.get(target - currSum);
					for (String s : curr) {
						String[] split = s.split(",");
						if (!split[0].equals(i + "") && !split[1].equals(i + "") && !split[0].equals(j + "")
								&& !split[1].equals(j + "")) {
							temp = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j],
									nums[Integer.valueOf(split[0])], nums[Integer.valueOf(split[1])]));
							Collections.sort(temp);
							unique.add(temp);
						}
					}
				}
			}
		}
		result.addAll(unique);
		return result;
	}

	public static void main(String[] args) {
		FourSum f = new FourSum();
		System.out.println(f.fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
	}

}
