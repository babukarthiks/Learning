package com.learning.algos.arrays;

/**
 * https://evelynn.gitbooks.io/facebook-interview/content/sort_colors.html
 */
public class SortColors {

    public static int[] sortColors(int[] colors) {

        if (colors == null || colors.length == 0) {
            return colors;
        }
        if (colors.length == 1) {
            return colors;
        }

        int start = 0, end = colors.length - 1, i = 0;

        while (i <= end) {

            if (colors[i] == 0) {
                colors[i] = colors[start];
                colors[start] = 0;
                start++;
                i++;
            } else if (colors[i] == 2) {
                colors[i] = colors[end];
                colors[end] = 2;
                end--;
                i++;
            } else if (colors[i] == 1) {
                i++;
            }
        }
        return colors;
    }

    public static void main(String[] args) {
        
        System.out.println(1 << 3);
        
        
//        for (int x : sortColors(new int[] { 2, 2, 2, 1, 1, 1, 0, 0, 0 })) {
//            System.out.print(x);
//        }
//        
//        for (int x : sortColors(new int[] { 2, 1, 0, 2, 1, 0, 2, 1, 0 })) {
//            System.out.print(x);
//        }
    }
    
    
    
    public static void test(){
        
        
        
    }

}
