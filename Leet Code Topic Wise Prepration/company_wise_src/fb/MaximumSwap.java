package Dec_09;

public class MaximumSwap {

	public int maximumSwap(int num) {
		if (num < 12) {
			return num;
		}
		char[] s = Integer.toString(num).toCharArray();
		int len = s.length;
		int[] maxToTheRight = new int[len]; // Contains the indexes of the greatest element to the right
		maxToTheRight[len - 1] = len - 1;

		// We are basically iterating all elements from the right to left to see
		// Which elements exist who are greater than the preceding elements
		for (int i = len - 2; i >= 0; i--) {
			if (s[i] - '0' > s[maxToTheRight[i + 1]] - '0') {
				maxToTheRight[i] = i;
			} else {
				maxToTheRight[i] = maxToTheRight[i + 1];
			}
		}

		for (int i = 0; i < len; i++) {
			// We swap the first smallest element on the left with the largest after it on
			// the right
			// This ensures that we swap the digit in the higher place
			if (s[i] - '0' < s[maxToTheRight[i]] - '0') {
				char temp = s[i];
				s[i] = s[maxToTheRight[i]];
				s[maxToTheRight[i]] = temp;
				break;// We break because we are only allowed 1 swap
			}
		}

		return Integer.valueOf(new String(s));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSwap m = new MaximumSwap();
		System.out.println(m.maximumSwap(1993));
	}

}
