package com.learning.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SkylineProblem {

    
        public static List<int[]> getSkyline(int[][] buildings) {
            List<int[]> result = new ArrayList<int[]>();
            List<int[]> height = new ArrayList<int[]>();
            for(int[] b:buildings) {
                height.add(new int[]{b[0], -b[2]});
                height.add(new int[]{b[1], b[2]});
            }
            Collections.sort(height, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    if(a[0] != b[0]){
                        return a[0] - b[0];
                    } else {
                        return a[1] - b[1];
                    }
                }
            });
            Queue<Integer> pq = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
                public int compare(Integer i1, Integer i2){
                    return i2 - i1;
                }
            });
            pq.offer(0);
            int prev = 0;
            for(int[] h:height) {
                if(h[1] < 0) {
                    pq.offer(-h[1]);
                } else {
                    pq.remove(h[1]);
                }
                int cur = pq.peek();
                if(prev != cur) {
                    result.add(new int[]{h[0], cur});
                    prev = cur;
                }
            }
            return result;
        }
        
        
        public static void main(String[] args) {
            int[][] buildings = new int[5][3];
            //[, [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
            buildings[0][0]=  2;
            buildings[0][1]=  9;
            buildings[0][2]=  10;
            buildings[1][0]=  3;
            buildings[1][1]=  7;
            buildings[1][2]=  15;
            buildings[2][0]=  5;
            buildings[2][1]=  12;
            buildings[2][2]=  12;
            buildings[3][0]=  15;
            buildings[3][1]=  20;
            buildings[3][2]=  10;
            buildings[4][0]=  19;
            buildings[4][1]=  24;
            buildings[4][2]=  8;
            
            getSkyline(buildings);
            
        }
}
