package Dec_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		if (strings == null || strings.length == 0) {
			return new ArrayList<List<String>>(0);
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strings) {
			String score = stringScores(s);
			List<String> temp = map.getOrDefault(score, new ArrayList<String>());
			temp.add(s);
			map.put(score, temp);
		}
		return new ArrayList<List<String>>(map.values());
	}

	private String stringScores(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length() - 1; i++) {
			int score = s.charAt(i + 1) - s.charAt(i);
			if (score < 0) {
				score += 26;
			}
			sb.append(score);
			sb.append(",");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((('b' - 'a') + 1) % 26);
	}

}
