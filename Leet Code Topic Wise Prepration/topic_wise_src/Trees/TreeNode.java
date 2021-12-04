package Trees;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		s.append("Val : " + val);
		if (left != null) {
			s.append(" left : " + left.val);
		} else {
			s.append(" left : NULL");
		}

		if (left != null) {
			s.append(" right : " + right.val);
		} else {
			s.append(" right : NULL");
		}

		return s.toString();
	}
}
