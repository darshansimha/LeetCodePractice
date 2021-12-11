package Dec_04;

public class ReverseInteger {
	public int reverse(int x) {
		boolean isNegative = x < 0;
		if(isNegative) {
			x = x*-1;
		}
		long result = 0;
		while(x > 0) {
			result = result*10 + x%10;
			x = x/10;
		}
		if(result > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) (isNegative ? result * -1 : result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(-123));
	}

}
