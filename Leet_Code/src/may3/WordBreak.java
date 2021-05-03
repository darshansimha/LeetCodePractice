package may3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];

		Set<String> dict = new HashSet<>();
		dict.addAll(wordDict);

		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				System.out.println(s.substring(j, i));
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak w = new WordBreak();
		List<String> dict = new ArrayList();
		dict.add("leet");
		dict.add("code");
		System.out.println(w.wordBreak("leetcode", dict));
	}

}
