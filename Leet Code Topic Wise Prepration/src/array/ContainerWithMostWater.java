package array;
//https://leetcode.com/problems/container-with-most-water/

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		if(height.length < 2) {
			return 0;
		}
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		int currArea = 0;
		while (right > left) {
			currArea = Math.min(height[left], height[right]) * (right - left);
			if (currArea > max) {
				max = currArea;
			}
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainerWithMostWater c = new ContainerWithMostWater();
		System.out.println(c.maxArea(new int[] { 1,2,1 }));
	}

}
