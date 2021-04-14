package april14;

import java.util.HashMap;
import java.util.Map;

public class MinDelToMakeCharFreqUnique {

	public int minDeletions(String s) {
		int result = 0;
		int[] arr = new int[26];

		for (char c : s.toCharArray()) {
			arr[c - 'a']++;
		}

		Map<Integer, Integer> addedFreq = new HashMap<>();
		
		int currCount = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				currCount = arr[i];
				if (!addedFreq.containsKey(arr[i])) {
					addedFreq.put(arr[i], 0);
				} else {
					for (int j = 0; j < arr[i]; j++) {
						currCount--;
						result++;
						if (!addedFreq.containsKey(currCount)) {
							if (currCount != 0) {
								addedFreq.put(currCount, 0);
								break;
							}
						}
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinDelToMakeCharFreqUnique m = new MinDelToMakeCharFreqUnique();
		System.out.println(m.minDeletions("abcabc"));
	}

}
