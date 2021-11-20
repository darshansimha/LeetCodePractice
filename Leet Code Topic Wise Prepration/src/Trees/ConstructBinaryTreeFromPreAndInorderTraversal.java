package Trees;

import java.util.Arrays;

import Common.TreeNode;

public class ConstructBinaryTreeFromPreAndInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
			return null;
		}

		int mid = -1;

		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				mid = i;
				break;
			}
		}

		TreeNode root = new TreeNode(preorder[0]);

		root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid + 1));

		root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
				Arrays.copyOfRange(inorder, mid + 1, inorder.length));

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreeFromPreAndInorderTraversal c = new ConstructBinaryTreeFromPreAndInorderTraversal();
		System.out.println(c.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }));
	}

}
