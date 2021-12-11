package Dec_05;

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] prefix = new int[len];
		int[] suffix = new int[len];

		prefix[0] = nums[0];
		suffix[len - 1] = nums[len - 1];
		for (int i = 1; i < len; i++) {
			prefix[i] = prefix[i - 1] * nums[i];
		}
		for (int i = len - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * nums[i];
		}
		int[] result = new int[len];

		result[0] = suffix[1];
		result[len - 1] = prefix[len - 2];

		for (int i = 1; i < len - 1; i++) {
			result[i] = prefix[i - 1] * suffix[i + 1];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
		System.out.println(p.productExceptSelf(new int[] { 1, 2, 3, 4 }));
	}

}
