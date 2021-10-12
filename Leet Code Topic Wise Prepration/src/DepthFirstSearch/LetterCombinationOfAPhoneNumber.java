package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
	String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	String digits = "";
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if(digits == null || digits.length() == 0) {
			return result;
		}
		this.digits = digits;
		letterCombinationsRec(result, 0, new StringBuilder().append(""));
		return result;
	}

	public void letterCombinationsRec(List<String> result, int index, StringBuilder current) {
		if (current.toString().length() == digits.length()) {
			result.add(current.toString());
			return;
		}
		String chars = map[digits.charAt(index) - '0'];

		for (int i = 0; i < chars.length(); i++) {
			letterCombinationsRec(result, index + 1, new StringBuilder().append(current).append(chars.charAt(i)));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationOfAPhoneNumber l = new LetterCombinationOfAPhoneNumber();
		System.out.println(l.letterCombinations("234"));
	}

}
