package array;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int size = nums.length;

		int[] l2r = new int[size];
		int[] r2l = new int[size];
		l2r[0] = nums[0];
		// Multiply all the elements from left to right and store the running product in the array
		for (int i = 1; i < size; i++) {
			l2r[i] = l2r[i - 1] * nums[i];
		}
		// Multiply all the elements from right to left and store the running product in the array
		r2l[size - 1] = nums[size - 1];
		for (int i = size - 2; i >= 0; i--) {
			r2l[i] = r2l[i + 1] * nums[i];
		}
		// End indexs are base cases
		nums[0] = r2l[1];
		nums[size - 1] = l2r[size - 2];
		
		//We run the algorithm for each index multiplying the left to right product before the current index and the right to left product after the index
		//This makes sure that the current index element is excluded
		for (int i = 1; i < size - 1; i++) {
			nums[i] = l2r[i - 1] * r2l[i + 1];
		}
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductofArrayExceptSelf p = new ProductofArrayExceptSelf();

		System.out.println(Arrays.toString(p.productExceptSelf(new int[] { -1,1,0,-3,3 })));
	}

}
