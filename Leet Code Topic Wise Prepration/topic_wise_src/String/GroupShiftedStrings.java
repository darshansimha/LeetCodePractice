package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> lengthGroup = new HashMap<String, List<String>>();
		List<String> temp;
		List<List<String>> result = new ArrayList<List<String>>();
		for (String s : strings) {
			String shiftingPattern = shiftingPattern(s);
			temp = lengthGroup.getOrDefault(shiftingPattern, new ArrayList<String>());
			temp.add(s);
			lengthGroup.put(shiftingPattern, temp);
		}
		for (List<String> group : lengthGroup.values()) {
			result.add(group);
		}
		return result;
	}

	private String shiftingPattern(String s) {
		if (s.length() == 0) {
			return " ";
		}
		if (s.length() == 1) {
			return ",";
		}
		StringBuilder pattern = new StringBuilder();
		for (int i = 0; i < s.length() - 1; i++) {
			int diff = s.charAt(i + 1) - s.charAt(i);
			if (diff < 0) {
				diff += 26;
			}
			pattern.append(diff + ",");
		}

		return pattern.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupShiftedStrings g = new GroupShiftedStrings();
		System.out.println(g.groupStrings(new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "al" }));
	}

}
