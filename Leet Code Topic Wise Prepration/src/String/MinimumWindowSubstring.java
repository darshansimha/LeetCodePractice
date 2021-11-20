package String;

import java.util.HashSet;
import java.util.Set;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (t.length() > s.length() || s == null || t == null) {
			return "";
		}
		if (s.indexOf(t) >= 0) {
			return t;
		}
		String result = new String(s);
		int left = findIndex(s, t, 0);

		if (left < 0) {
			return "";
		}
		Set<Character> visited = new HashSet<Character>();
		StringBuilder current = new StringBuilder();
		visited.add(s.charAt(left));
		for (int right = left; right < s.length(); right++) {
			if(visited.size() == t.length()) {
				if(current.length() < result.length()) {
					result = current.toString();
				}
			}
		}
		return result;
	}

	private int findIndex(String s, String t, int start) {
		for (int i = start; i < s.length(); i++) {
			if (t.indexOf(s.charAt(i)) >= 0) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
