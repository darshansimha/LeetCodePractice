package array;

public class TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int result = 0;
		int left = 0;
		int right = height.length - 1;

		int leftMax = height[left];
		int rightMax = height[right];

		while (left < right) {
			if (leftMax < rightMax) {
				left += 1;
				leftMax = Math.max(leftMax, height[left]);
				result += leftMax - height[left];
			} else {
				right -= 1;
				rightMax = Math.max(rightMax, height[right]);
				result += rightMax - height[right];

			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
