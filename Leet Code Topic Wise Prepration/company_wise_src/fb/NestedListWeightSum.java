package Dec_10;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {
	int result;

	class NestedInteger {
		// Constructor initializes an empty nested list.
		public NestedInteger() {
		}

		// Constructor initializes a single integer.
		public NestedInteger(int value) {
		}

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger() {
			return true;
		};

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			return 0;
		};

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {
			return;
		};

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni) {
			return;
		};

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return empty list if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			return new ArrayList<>();
		};
	}

	public int depthSum(List<NestedInteger> nestedList) {
		result = 0;
		depthSumHelper(nestedList, 1);
		return result;
	}

	private void depthSumHelper(List<NestedInteger> nestedList, int level) {
		for (NestedInteger n : nestedList) {
			if (n.isInteger()) {
				result += n.getInteger() * level;
			} else {
				depthSumHelper(n.getList(), level + 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
