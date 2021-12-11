package Dec_08;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {
	Map<Integer, Integer> nonZeroIndexMap;

	DotProductOfTwoSparseVectors(int[] nums) {
		nonZeroIndexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nonZeroIndexMap.put(i, nums[i]);
			}
		}
	}

	// Return the dotProduct of two sparse vectors
	public int dotProduct(DotProductOfTwoSparseVectors vec) {
		Map<Integer, Integer> vecMap = vec.nonZeroIndexMap;
		int result = 0;
		for (int i : vecMap.keySet()) {
			if (nonZeroIndexMap.containsKey(i)) {
				result += vecMap.get(i) * nonZeroIndexMap.get(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
