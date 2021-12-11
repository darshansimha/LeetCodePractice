package Dec_04;

public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		if (numbers == null || numbers.length < 2) {
			return result;
		}
		int len = numbers.length;
		int left = 0;
		int right = len - 1;
		int curr = 0;
		while (right > left) {
			curr = numbers[right] + numbers[left];
			if (curr > target) {
				right--;
			} else if (curr < target) {
				left++;
			} else {
				//Because the solution needs you to add 1 to your index
				result[0] = left + 1;
				result[1] = right + 1;
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
