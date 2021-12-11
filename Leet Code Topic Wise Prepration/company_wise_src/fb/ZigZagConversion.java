package Dec_04;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0) {
			return "";
		}
		if (numRows == 1) {
			return s;
		}

		StringBuilder result = new StringBuilder();
		int len = s.length();

		for (int row = 0; row < numRows; row++) {
			int increment = (numRows - 1) * 2;
			for (int i = row; i < len; i = i + increment) {
				result.append(s.charAt(i));
				if (row > 0 && row < numRows - 1 && i + increment - 2 * row < len) {
					result.append(s.charAt(i + increment - 2 * row));
				}
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
