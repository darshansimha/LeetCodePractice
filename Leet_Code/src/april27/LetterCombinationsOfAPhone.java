package april27;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhone {
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<>();
    	if(digits == null || digits.length() == 0 ) {
    		return result;
    	}
        String[] mappings = new String[] {
        		"",
        		"",
        		"abc",
        		"def",
        		"ghi",
        		"jkl",
        		"mno",
        		"pqrs",
        		"tuv",
        		"wxyz"
        };
        letterCombinationRec(digits, result, "", 0, mappings);
    	return result;
    }
    public void letterCombinationRec(String digits, List<String> result, String current, int index, String[] mappings) {
    	if(current.length() == digits.length()) {
    		result.add(current);
    		return;
    	}
    	String letters = mappings[digits.charAt(index) - '0'];
    	
    	for(int i = 0; i < letters.length(); i++) {
    		letterCombinationRec(digits, result, current + letters.charAt(i), index + 1, mappings);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsOfAPhone l = new LetterCombinationsOfAPhone();
		System.out.println(l.letterCombinations("23"));
	}

}
