package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NumberOfUniqueEmails {
	public int numUniqueEmails(String[] emails) {
		int result = 0;
		Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

		for (String email : emails) {
			String[] split = email.split("@");
			String userName = getUserName(split[0]);
			HashSet<String> temp = new HashSet<String>();
			if (map.containsKey(split[1])) {
				temp = map.get(split[1]);
			}
			temp.add(userName);
			map.put(split[1], temp);
		}
		for (HashSet<String> s : map.values()) {
			result += s.size();
		}
		return result;
	}

	private String getUserName(String name) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i) == '+') {
				break;
			} else if(name.charAt(i) == '.') {
				continue;
			} else {
				sb.append(name.charAt(i));
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfUniqueEmails n = new NumberOfUniqueEmails();
		System.out.println(n.numUniqueEmails(new String[] {"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
	}

}
