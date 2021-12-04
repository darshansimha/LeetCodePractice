package sliding_window;

public class MaximumSumOfASubarrayOfSizeK {
	 public int maxSum(int arr[], int k) {
		 int left = 0; int right = 0;
		 int maxSum = 0;
		 int len = arr.length;
		 for(int i = 0; i < k; i++) {
			 maxSum += arr[i];
		 }
		 right = k - 1;
		 int currSum = maxSum;
		 
		 while(right < len) {
			 currSum += arr[right] - arr[left];
			 left++;
			 right++;
			 maxSum = Math.max(maxSum, currSum);
		 }
		 
		 return maxSum;
	 }
}
