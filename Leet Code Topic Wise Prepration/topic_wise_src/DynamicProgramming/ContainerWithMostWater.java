package DynamicProgramming;

public class ContainerWithMostWater {
	public int maxAreaBruteForce(int[] height) {
		int result = 0;

		int left = 0;
		int right = left + 1;
		int currArea = 0;
		while (left < height.length - 1) {
			currArea = Math.min(height[left], height[right]) * (right - left);
			if (currArea > result) {
				result = currArea;
			}
			right++;
			if (right == height.length) {
				left++;
				right = left + 1;
			}
		}
		return result;
	}

	public int maxArea(int[] height) {
		int result = 0;
		int left = 0;
		int right = height.length - 1;
		int currArea = 0;

		while (left < right) {
			currArea = Math.min(height[left], height[right]) * (right - left);
			if (currArea > result) {
				result = currArea;
			}
			if (height[left] < height[right]) {
				left++;
			} else if (height[right] < height[left]) {
				right--;
			} else {
				left++;
				right--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainerWithMostWater c = new ContainerWithMostWater();

		System.out.println(c.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

}
