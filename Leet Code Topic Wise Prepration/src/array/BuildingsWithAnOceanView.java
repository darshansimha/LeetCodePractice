package array;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithAnOceanView {
	public int[] findBuildings(int[] heights) {
		if (heights == null) {
			return null;
		}
		if (heights.length == 1) {
			return new int[] { 0 };
		}
		int len = heights.length;
		int[] rightMax = new int[len];
		rightMax[len - 1] = -1;
		int currMax = heights[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			rightMax[i] = currMax;
			currMax = Math.max(currMax, heights[i]);
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			if (heights[i] > rightMax[i]) {
				result.add(i);
			}
		}
		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildingsWithAnOceanView b = new BuildingsWithAnOceanView();
		System.out.println(b.findBuildings(new int[] { 4, 2, 3, 1 }));
	}

}
