package Dec_04;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		StringBuilder lcp = new StringBuilder();
		char curr = ' ';
		for (int i = 0; i < strs[0].length(); i++) {
			curr = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(i >= strs[j].length() || strs[j].charAt(i) != curr) {
					return lcp.toString();
				}
			}
			lcp.append(curr);
		}
		
		return lcp.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(new String[] {"ab", "a"}));
	}

}
