package String;

public class ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
		boolean result = true;

		String num = "";
		int idx = 0;
		for (int i = 0; i < abbr.length(); i++) {
			if (Character.isLetter(abbr.charAt(i))) {
				if (num == "") {
					if (word.charAt(idx) != abbr.charAt(i)) {
						return false;
					}
					idx++;
				} else {
					idx += Integer.valueOf(num);
					num = "";
					if (word.charAt(idx) != abbr.charAt(i)) {
						return false;
					}
					idx++;
				}
			} else {
				num += abbr.charAt(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidWordAbbreviation v = new ValidWordAbbreviation();
		System.out.println(v.validWordAbbreviation("internationalization", "i12iz4n"));
	}

}
