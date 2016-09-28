package com.learning.questions;

import com.learning.ds.pojos.TreeNode;

public class CheckBST {

	TreeNode previous = null;

	public boolean checkBST(TreeNode node) {

		if (node == null)
			return true;
		// check till the last left node
		if (!checkBST(node.getLeft())) {
			return false;
		}
		// if the current value is less than its prior node then its not bst
		if (previous != null && previous.getValue() > node.getValue()) {
			return false;
		}
		// set current visiting node as prev for right node
		previous = node;

		return checkBST(node.getRight());

	}
}
