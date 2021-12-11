package Dec_10;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		// Special case: overflow.
	    if (dividend == Integer.MIN_VALUE && divisor == -1) {
	        return Integer.MAX_VALUE;
	    }

		int quotient = 0;
		boolean isNegative = false;
		if (dividend < 0 && divisor > 0) {
			isNegative = true;
			dividend = dividend * -1;
		} else if (divisor < 0 && dividend > 0) {
			isNegative = true;
			divisor = divisor * -1;
		} else if (divisor < 0 && dividend < 0) {
			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);
		}
		if (divisor == 1) {
			quotient = dividend;
			return isNegative ? -1 * quotient : quotient;
		}
		while (dividend >= divisor) {
			dividend -= divisor;
			quotient++;
		}

		return isNegative ? -1 * quotient : quotient;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(-2147483648, -1));
	}

}
