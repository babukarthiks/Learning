package com.learning.algos.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.learning.ds.pojos.TreeNode;

public class BFS {

    public List<List<Integer>> printLevelOrderTraversal(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        List<List<Integer>> levelOrderTraversal = new ArrayList<List<Integer>>();

        queue.offer(node);

        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<Integer>();

            for (int i = 0; i < queue.size(); i++) {

                TreeNode temp = queue.poll();

                if (null == temp.getLeft()) {
                    queue.offer(temp.getLeft());
                }

                if (null == temp.getRight()) {
                    queue.offer(temp.getRight());
                }

                level.add(temp.getValue());
            }
            levelOrderTraversal.add(level);
        }
        return levelOrderTraversal;
    }
}
