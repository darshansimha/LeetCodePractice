package Dec_11;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || k <= 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int maxLen = 0, left = 0, right = 0, len = s.length();
		//Stores the frequency of each character in my sliding window
		Map<Character, Integer> map = new HashMap<>();
		while (right < len) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			//Do this until we achieve the equilibrium i.e. map size == k
			while (left < right && map.size() > k) {
				//If frequency is zero we remove from the map
				if (map.get(s.charAt(left)) - 1 == 0) {
					map.remove(s.charAt(left));
				} else {
					//Otherwise we keep decrementing the count
					map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
				}
				left++;
			}
			maxLen = Math.max(maxLen, (right - left + 1));
			right++;
		}
		return maxLen;
	}
	public static void main(String[] args) {
		LongestSubstringwithAtMostKDistinctCharacters l = new LongestSubstringwithAtMostKDistinctCharacters();
		System.out.println(l.lengthOfLongestSubstringKDistinct("abababazazazabababaz", 2));
	}
	
}
