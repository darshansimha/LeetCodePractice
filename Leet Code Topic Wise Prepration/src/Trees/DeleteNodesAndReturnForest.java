package Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i : to_delete) {
			set.add(i);
		}
		delNodesRec(root, set, result);
		if (!set.contains(root.val)) {
			result.add(root);
		}
		return result;
	}

	private void delNodesRec(TreeNode root, Set<Integer> set, List<TreeNode> result) {
		if (root == null) {
			return;
		}
		if (set.contains(root.val)) {
			if (root.left != null) {
				result.add(root.left);
				root.left = null;
			}
			if (root.right != null) {
				result.add(root.right);
				root.right = null;
			}
		}
		delNodesRec(root.left, set, result);
		delNodesRec(root.right, set, result);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNodesAndReturnForest d = new DeleteNodesAndReturnForest();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(d.delNodes(root, new int[] { 3, 5 }));
	}

}
