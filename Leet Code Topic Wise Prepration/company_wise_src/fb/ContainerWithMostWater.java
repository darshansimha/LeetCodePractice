package Dec_04;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0 || height.length == 1) {
			return 0;
		}

		int result = 0;
		int len = height.length;
		int left = 0;
		int right = len - 1;

		while (right > left) {
			result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
