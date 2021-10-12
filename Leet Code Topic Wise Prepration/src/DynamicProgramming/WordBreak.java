package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		Set<String> st = new HashSet<>();
		st.addAll(wordDict);
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if(dp[j] && st.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak w = new WordBreak();
		List<String> s = new ArrayList<>();
//		s.add("cats");
//		s.add("dog"); "a","abc","b","cd"
		s.add("a");
		s.add("abc");
		s.add("b");
		s.add("cd");
		System.out.println(w.wordBreak("abcd", s));
	}

}
