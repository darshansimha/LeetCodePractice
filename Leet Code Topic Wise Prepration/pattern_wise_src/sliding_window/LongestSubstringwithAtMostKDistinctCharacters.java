package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		 if(k == 0 || s == null || s.length() == 0) {
			return 0;
		}
		int maxLen = 1;
		int left = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int right = 0;
		for (; right < s.length(); right++) {
			if (map.containsKey(s.charAt(right))) {
				maxLen = Math.max(maxLen, (right - left) + 1);
				map.put(s.charAt(right), right);
			} else {
				if (map.size() < k) {
					map.put(s.charAt(right), right);
					maxLen = Math.max(maxLen, (right - left) + 1);
				} else {
					left = map.get(s.charAt(left));
				}
			}
		}

		return Math.max(maxLen, right - left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringwithAtMostKDistinctCharacters l = new LongestSubstringwithAtMostKDistinctCharacters();
		System.out.println(l.lengthOfLongestSubstringKDistinct("ab", 1));
	}

}
