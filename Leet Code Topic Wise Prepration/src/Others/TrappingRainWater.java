package Others;

public class TrappingRainWater {
	public int trap(int[] height) {
		if(height.length == 0 || height.length == 1 || height.length == 2){
            return 0;
        }
		int result = 0;

		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];

		leftMax[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			if (height[i] > leftMax[i - 1]) {
				leftMax[i] = height[i];
			} else {
				leftMax[i] = leftMax[i - 1];
			}
		}

		rightMax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			if (height[i] > rightMax[i + 1]) {
				rightMax[i] = height[i];
			} else {
				rightMax[i] = rightMax[i + 1];
			}
		}

		for (int i = 1; i < height.length - 1; i++) {
			result += Math.min(leftMax[i], rightMax[i]) - height[i];
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater t = new TrappingRainWater();

		System.out.println(t.trap(new int[] { 1,8,6,2,5,4,8,3,7 }));
	}

}
