package Trees;

public class BinaryTreeMaximumPathSum {
	int result = 0;

	public int maxPathSum(TreeNode root) {
		result = Integer.MIN_VALUE;
		dfs(root);
		return result;
	}

	private int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = Math.max(0, dfs(root.left));
		int right =  Math.max(0, dfs(root.right));
		
		result = Math.max(result, left + right + root.val);
		
		return root.val + Math.max(left, right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
