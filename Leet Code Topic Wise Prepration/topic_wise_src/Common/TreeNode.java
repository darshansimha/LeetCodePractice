package Common;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Val : " + val);
		if(left != null) {
			sb.append(" Left : " + left.val + " ");
		} else {
			sb.append(" Left : null ");
		}
		if(right != null) {
			sb.append(" Right : " + right.val + " ");
		} else {
			sb.append(" Right : null");
		}
		return sb.toString();
	}
}
