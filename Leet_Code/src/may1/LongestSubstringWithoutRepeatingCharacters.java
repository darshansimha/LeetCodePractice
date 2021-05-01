package may1;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int result = 1;

		int left = 0;
		int right = left + 1;
		char[] arr = s.toCharArray();

		Set<Character> visited = new HashSet<>();

		visited.add(arr[left]);

		while (right < s.length()) {
			if (visited.contains(arr[right])) {
				result = Math.max(result, right - left);
				for (int i = left; i < right; i++) {
					if (arr[i] == arr[right]) {
						visited.clear();
						left = i + 1;
						right = left + 1;
						visited.add(arr[left]);
						break;
					}
				}
			} else {
				visited.add(arr[right]);
				right++;
			}
		}

		return Math.max(result, visited.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();

		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
	}

}
