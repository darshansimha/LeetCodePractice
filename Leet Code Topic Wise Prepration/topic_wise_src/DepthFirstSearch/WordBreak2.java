package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {

	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<>();
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (String str : wordDict) {
			if (s.indexOf(str) == 0) {
				wordBreakRec(s.substring(str.length(), s.length()), wordDict, str, dp, result);
			}
		}

		return result;
	}

	public void wordBreakRec(String s, List<String> wordDict, String current, boolean[] dp, List<String> result) {
		if (s.equals("")) {
			result.add(current);
			return;
		}
		for (String str : wordDict) {
			if (s.indexOf(str) == 0) {
				wordBreakRec(s.substring(str.length(), s.length()), wordDict, current + " " + str, dp, result);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak2 w = new WordBreak2();
		List<String> dict = new ArrayList<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(w.wordBreak("catsandog", dict));
	}

}
