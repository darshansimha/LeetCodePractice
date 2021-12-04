package String;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		if(s == null || s.length() == 0 || k < 0) {
			return 0;
		}
		if(s.length() == 1 && k >= s.length()) {
			return 1;
		}
		int result = 1;
		int left = 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int right = 0; right < s.length(); right++) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			int maxCount = Collections.max(map.values());

			while ((right - left) + 1 - maxCount > k) {
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
				left++;
			}

			result = Math.max(result, (right - left + 1));
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
		System.out.println(l.characterReplacement("AABABBA", 1));
	}

}
