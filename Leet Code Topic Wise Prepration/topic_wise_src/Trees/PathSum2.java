package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer>curr = new ArrayList<Integer>();
		curr.add(root.val);
		pathSumRec(root, targetSum - root.val, curr, result);
		return result;
	}

	public void pathSumRec(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> result) {
		if (root.left == null && root.right == null) {
			if (targetSum == 0) {
				result.add(new ArrayList<>(current));
				return;
			}
			return;
		}
		
		if (root.left != null) {
			current.add(root.left.val);
			pathSumRec(root.left, targetSum - root.left.val, current, result);
			current.remove(current.size() - 1);
		}
		if (root.right != null) {
			current.add(root.right.val);
			pathSumRec(root.right, targetSum - root.right.val, current, result);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum2 p = new PathSum2();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		System.out.println(p.pathSum(root, 22));
	}

}
