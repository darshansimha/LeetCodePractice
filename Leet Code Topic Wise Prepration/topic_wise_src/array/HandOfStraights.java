package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

	public boolean isNStraightHand(int[] hand, int groupSize) {
		int len = hand.length;
		if (hand == null || groupSize == 0 || hand.length == 0) {
			return false;
		}
		if (len % groupSize != 0) {
			return false;
		}
		Arrays.sort(hand);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
		}

		for (int i : hand) {
			if (map.get(i) > 0) {
				for (int j = 0; j < groupSize; j++) {
					if (map.getOrDefault(i + j, 0) == 0) {
						return false;
					}
					map.put(i + j, map.get(i + j) - 1);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
