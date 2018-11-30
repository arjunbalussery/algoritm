package com.company;

public class DP {
    public static int increasingSeequence (int []array) {
        int size = array.length;
        int[] ls = new int[size];
        int max=1;
        for (int i=0;i<size;i++) {
            ls[i]=1;
        }
        for (int i=1;i<size;i++) {
            for (int j=0;j<i;j++) {
                if (array[i] > array[j] && ls[i] <= ls[j]+1) {
                    ls[i]=ls[j]+1;
                    if (max < ls[i])max=ls[i];
                }
            }
        }
        for (int i=0;i<size;i++) {
            System.out.print(ls[i]);
        }

        return max;
    }

    public static int longestPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        return findLong(matrix,row-1,col-1,row-1,col-1);
    }

    private static int findLong(int[][] matrix, int row, int col,int ROW, int COL) {
        if(row<0 || col < 0)
            return 0;
        if (row==0 && col==0)
            return 0;
        int value = matrix[row][col];
        int right =-1;
        int left=-1;
        int top=-1;
        int bottom=-1;
        if (isValid(value,row+1,col,matrix,ROW,COL))
            return 1+ findLong(matrix,row+1,col,ROW,COL);

        if (isValid(value,row-1,col,matrix,ROW,COL))
            return 1+findLong(matrix,row-1,col,ROW,COL);
        if (isValid(value,row,col+1,matrix,ROW,COL))
            return 1+findLong(matrix,row,col+1,ROW,COL);
        if (isValid(value,row,col-1,matrix,ROW,COL))
            return 1+findLong(matrix,row,col-1,ROW,COL);
/*        if (right >=0 || left >=0 || top>=0 || bottom >=0)
            return 1+max(right,left,top,bottom);*/
        return 0;

    }

    private static boolean isValid(int value, int row, int col, int[][] matrix, int ROW, int COL) {
        if (row <0 || col < 0 || row > ROW || col > COL )
            return false;
        return Math.abs(value-matrix[row][col])==1;
    }
    private static int max(int right,int left,int top,int bottom) {
        if(right > left && right > top && right > bottom)
            return right;
        if(left > right && left > top && left > bottom)
            return right;
        if(top > left && top > right && top > bottom)
            return right;
        return bottom;
    }

    public static boolean fidndSubset(int [] set,int total) {
        int n= set.length;
        return findSubset(set,n-1,total,0);
    }

    private static boolean findSubset(int[] set, int index,int total,int calSum) {
        if(index < 0)
            return false;
        if (calSum > total) //if there is no non negative integers
            return false;
        if (calSum == total)
            return true;

        return (findSubset(set,index-1,total,calSum+set[index]) || findSubset(set,index-1,total,calSum));
    }


}
