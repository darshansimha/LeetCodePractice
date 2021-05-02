package may2;

import java.util.Arrays;

public class MinimumWindowSubString {
	public String minWindow(String s, String t) {

		String min = s;

		int start = findStart(s, t, 0, s.length()), end = start + 1;

		int[] chars = new int[26];

		resetCharArray(chars, t);

		chars[s.charAt(start) - 'A']--;

		while (start < s.length()) {
			if (hasAll(chars, t)) {
				if (min.length() > s.substring(start, end + 1).length()) {
					min = s.substring(start, end + 1);
				}
			}
			start = findStart(s, t, start + 1, s.length());
			end = start + 1;
			resetCharArray(chars, t);

			chars[s.charAt(end) - 'A']--;
			end++;

		}

		return min;
	}

	public boolean hasAll(int[] arr, String t) {
		for (char c : t.toCharArray()) {
			if (arr[c - 'A'] != 0) {
				return false;
			}
		}
		return true;
	}

	public void resetCharArray(int[] arr, String t) {
		Arrays.fill(arr, 0);
		for (char c : t.toCharArray()) {
			arr[c - 'A']++;
		}
	}

	public int findStart(String s, String t, int start, int end) {
		int result = 0;
		for (int i = start; i < end; i++) {
			if (t.indexOf(s.charAt(i)) >= 0) {
				result = i;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubString m = new MinimumWindowSubString();
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
	}

}
