package Dec_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
	Map<String, Boolean> cache;

	public boolean wordBreak(String s, List<String> wordDict) {
		cache = new HashMap<>();
		for (String word : wordDict) {
			cache.put(word, true);
		}
		return wordBreakHelper(s, wordDict);
	}

	private boolean wordBreakHelper(String s, List<String> wordDict) {
		if(cache.containsKey(s)) {
			return cache.get(s);
		}
		if (s.length() == 0) {
			return true;
		}
		boolean result = false;
		for (String word : wordDict) {
			if (s.indexOf(word) == 0) {
				result = result || wordBreakHelper(s.substring(word.length(), s.length()), wordDict);
			}
		}
		cache.put(s, result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak w = new WordBreak();
		System.out.println(w.wordBreak("leetcode", Arrays.asList("leet", "code")));
	}

}
