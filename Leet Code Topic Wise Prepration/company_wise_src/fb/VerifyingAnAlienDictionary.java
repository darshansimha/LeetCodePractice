package Dec_05;

public class VerifyingAnAlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {
		boolean result = true;
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				if (j >= words[i + 1].length()) {
					return false;
				}
				if (words[i].charAt(j) != words[i + 1].charAt(j)) {
					if (order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))) {
						return false;
					} else {
						break;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyingAnAlienDictionary v = new VerifyingAnAlienDictionary();
		System.out.println(v.isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
	}

}
