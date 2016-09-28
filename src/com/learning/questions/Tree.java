package com.learning.questions;

import com.learning.ds.pojos.TreeNode;

public class Tree {

	public boolean isBalanced(TreeNode root) {

		int result = checkBalanced(root);
		return true;
	}

	private int checkBalanced(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = checkBalanced(root.getLeft());

		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = checkBalanced(root.getRight());

		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight);

	}

	public TreeNode commonAncestorInBST(TreeNode root, TreeNode node1, TreeNode node2) {

		if (root.getValue() > Math.max(node1.getValue(), node2.getValue())) {
			return commonAncestorInBST(root.getLeft(), node1, node2);
		} else if (root.getValue() < Math.min(node1.getValue(), node2.getValue())) {
			return commonAncestorInBST(root.getRight(), node1, node2);
		} else {
			return root;
		}
	}

	public TreeNode commonAncestorInBT(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null) {
			return null;
		}

		if (root.getValue() == node1.getValue() || node2.getValue() == root.getValue()) {
			return root;
		}

		TreeNode left = commonAncestorInBT(root.getLeft(), node1, node2);
		TreeNode right = commonAncestorInBT(root.getRight(), node1, node2);

		if (left != null && right != null) {
			return root;
		}
		if (left == null && right == null) {
			return null;
		}

		return left == null ? right : left;
	}

}
