package com.learning.algos.trees;

public class TreesMain {

    public static void main(String[] args) {
        Tree tree = new Tree();

//        tree.insert(2);
//        tree.insert(1);
//        tree.insert(3);
//        tree.insert(4);
//        tree.insert(-6);
//
//        tree.print();
//        System.out.println();
//        System.out.println("size : " + tree.size());
//        System.out.println("depth : " + tree.maxDepth());
//        System.out.println("min value : " + tree.minValue());
//        System.out.println("max value : " + tree.maxValue());
//        System.out.println("has sum : " + tree.hasPathSum(12));
//        System.out.println(tree.hasNode(2));
//        tree.printNodesFromDistance(2, 2);
        
        
        tree.str2tree("4(2(3)(1))(6(5))");
    }
}
