package Dec_04;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		if (s == null || s.length() == 0) {
			return result;
		}

		int left = 0;
		int right = 0;
		int len = s.length();

		int[] chars = new int[128];

		while (right < len) {
			char curr = s.charAt(right);
			chars[curr]++;
			
			while (chars[curr] > 1) {
				chars[s.charAt(left)]--;
				left++;
			}
			if (right - left + 1 > result) {
				result = right - left + 1;
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
