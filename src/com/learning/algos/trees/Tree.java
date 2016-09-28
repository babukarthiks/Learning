package com.learning.algos.trees;

import java.util.Stack;

import com.learning.ds.pojos.TreeNode;

public class Tree {

    public TreeNode root;

    public void insert(int key) {
        root = insert(root, key);
    }

    public TreeNode insert(TreeNode node, int key) {

        if (node == null) {
            return new TreeNode(key);
        }

        if (key < node.getValue()) {
            node.setLeft(insert(node.getLeft(), key));
        } else if (key >= node.getValue()) {
            node.setRight(insert(node.getRight(), key));
        }
        return node;
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return numberOfLeaves(root);
    }

    public int numberOfLeaves(TreeNode node) {
        int size = 1;
        if (node == null) {
            return 0;
        }

        size += numberOfLeaves(node.getLeft());
        size += numberOfLeaves(node.getRight());

        return size;
    }

    public void print() {
        printFromNode(root);
    }

    public void printFromNode(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue());
        printFromNode(node.getLeft());
        printFromNode(node.getRight());
    }

    public int maxDepth() {

        if (root == null) {
            return 0;
        }
        return depthFromNode(root, 0);
    }

    public int depthFromNode(TreeNode node, int maxDepth) {

        if (node == null) {
            return 0;
        }
        int leftDepth = 0, rightDepth = 0;

        leftDepth = 1 + depthFromNode(node.getLeft(), maxDepth);
        rightDepth = 1 + depthFromNode(node.getRight(), maxDepth);

        maxDepth = Math.max(leftDepth, rightDepth);
        return maxDepth;
    }

    public int minValue() {
        TreeNode node = root;
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    public int maxValue() {
        TreeNode node = root;
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getValue();
    }

    public boolean hasNode(int value) {
        return findNode(root, value) == null ? false : true;
    }

    private TreeNode findNode(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.getValue() > value) {
            return findNode(node.getLeft(), value);
        } else if (node.getValue() < value) {
            return findNode(node.getRight(), value);
        } else {
            return node;
        }
    }

    public boolean hasPathSum(int sum) {
        if (root == null && sum == 0) {
            return true;
        }

        return hasPathSumFromNode(root, 0, sum);
    }

    public boolean hasPathSumFromNode(TreeNode node, int currentSum, int sum) {
        if (currentSum == sum) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return hasPathSumFromNode(node.getLeft(), currentSum + node.getValue(), sum)
                || hasPathSumFromNode(node.getRight(), currentSum + node.getValue(), sum);
    }

    public void mirror() {
        mirror(root);
    }

    private void mirror(TreeNode node) {
        if (node == null)
            return;

        mirror(node.getLeft());
        mirror(node.getRight());

        TreeNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
    }

    public void printNodesFromDistance(int fromNode, int distance) {
        printNodesFromDistance(findNode(root, fromNode), distance, 0);
    }

    private void printNodesFromDistance(TreeNode fromNode, int distance, int move) {
        if (fromNode == null || move > distance) {
            return;
        }
        if (move == distance) {
            System.out.print(fromNode.getValue());
        }
        printNodesFromDistance(fromNode.getLeft(), distance, move + 1);
        printNodesFromDistance(fromNode.getRight(), distance, move + 1);
    }

    public void checkParentEqualsSumOfLeftAndRight() {
        Stack<TreeNode> itemsStack = new Stack<TreeNode>();
        itemsStack.push(root);
        checkParentEqualsSumOfLeftAndRight(itemsStack);
    }

    private boolean checkParentEqualsSumOfLeftAndRight(Stack<TreeNode> itemsStack) {

        while (!itemsStack.empty()) {
            TreeNode node = itemsStack.pop();
            if ((node.getLeft() != null && node.getRight() == null)
                    || (node.getLeft() == null && node.getRight() != null)) {
                return false;
            }
            if (node.getLeft() == null && node.getRight() == null) {
                continue;
            }
            if (node.getLeft().getValue() + node.getRight().getValue() == node.getValue()) {
                itemsStack.push(node.getLeft());
                itemsStack.push(node.getRight());
            } else {
                return false;
            }
        }
        return true;
    }

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                int j = i;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    i++;
                TreeNode curt = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if (stack.isEmpty())
                    stack.push(curt);
                else {
                    TreeNode parent = stack.peek();
                    if (parent.getLeft() == null)
                        parent.setLeft(curt);
                    else
                        parent.setRight(curt);
                    stack.push(curt);
                }
            }
            if (s.charAt(i) == ')')
                stack.pop();
        }
        return stack.pop();
    }

}
