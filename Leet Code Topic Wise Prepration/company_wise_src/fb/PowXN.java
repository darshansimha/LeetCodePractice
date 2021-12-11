package Dec_08;

public class PowXN {
	public double myPow(double x, int n) {
        if(n < 0) {
        	x = 1/x;
        }
        return myPowHelper(x, n);
    }

	public double myPowHelper(double x, int n) {
		if(n == 0) {
        	return 1.0;
        }
        double half = myPowHelper(x, n/2);
        if(n % 2 == 0) {
        	return  half * half; 
        } else {
        	return x * half * half;
        }
	}
}
