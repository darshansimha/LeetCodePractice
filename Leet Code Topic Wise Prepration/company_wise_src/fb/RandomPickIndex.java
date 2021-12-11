package Dec_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {
	Map<Integer, List<Integer>> map;
	private Random rand;
	public RandomPickIndex(int[] nums) {
		map = new HashMap<Integer, List<Integer>>();
		rand = new Random();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> temp = map.getOrDefault(nums[i], new ArrayList<Integer>());
			temp.add(i);
			map.put(nums[i], temp);
		}
	}

	public int pick(int target) {
		List<Integer> set = map.get(target);
		int index = set.get(rand.nextInt(set.size()));
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
