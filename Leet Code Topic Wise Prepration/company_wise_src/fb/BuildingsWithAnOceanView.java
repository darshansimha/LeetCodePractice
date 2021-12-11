package Dec_05;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithAnOceanView {
	public int[] findBuildings(int[] heights) {
		List<Integer> result = new ArrayList<Integer>();
		if (heights == null || heights.length == 0) {
			return null;
		}
		int currMaxHeight = 0;
		int len = heights.length;
		for (int i = len - 1; i >= 0; i--) {
			if (heights[i] > currMaxHeight) {
				result.add(0, i);
			}
			currMaxHeight = Math.max(currMaxHeight, heights[i]);
		}
		
		int[] res = new int[result.size()];
		
		int idx = 0;
		for(int i : result) {
			res[idx] = i;
			idx++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
