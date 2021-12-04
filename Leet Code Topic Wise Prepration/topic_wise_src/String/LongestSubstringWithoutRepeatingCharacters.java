package String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		if(s.length() == 1) {
			return 1;
		}
		int result = 1;
		
		Set<Character> unique = new HashSet<Character>();
		
		int left = 0;
		int right = left + 1;
		unique.add(s.charAt(left));
		while(right > left && right < s.length()) {
			while(left < right && unique.contains(s.charAt(right))) {
				unique.remove(s.charAt(left));
				left++;
			}
			unique.add(s.charAt(right));
			if(result < unique.size()) {
				result = unique.size();
			}
			right++;
		}
 		
		return result;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
	}

}
