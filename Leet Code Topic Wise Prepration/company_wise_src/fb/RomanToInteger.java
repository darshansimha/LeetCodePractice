package Dec_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanToInteger {
	public int romanToInt(String s) {
		int result = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		Stack<Character> stack = new Stack<Character>();

		int len = s.length();

		for (int i = 0; i < len; i++) {
			if (!stack.isEmpty() && map.get(s.charAt(i)) > map.get(stack.peek())) {
				result -= map.get(stack.pop());
			}
			stack.push(s.charAt(i));
		}
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			result += map.get(stack.pop());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToInteger r = new RomanToInteger();
		System.out.println(r.romanToInt("IV"));
	}

}
