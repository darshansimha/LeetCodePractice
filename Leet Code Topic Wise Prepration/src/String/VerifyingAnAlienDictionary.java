package String;

public class VerifyingAnAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
		int[] alp = new int[26];
		int index = 1;
		for(char c : order.toCharArray()) {
			int idx = c - 'a';
			alp[idx] = index;
			index++;
		}
		
		for(int i = 0; i < words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];
			
			for(int j = 0; j < w1.length(); j++) {
				if(j == w2.length()) {
					return false;
				}
				
				if(w1.charAt(j) != w2.charAt(j)) {
					if(alp[w1.charAt(j) - 'a'] > alp[w2.charAt(j) - 'a']) {
						return false;
					} else {
						break;
					}
				}
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
