package com.company;

public class BinarySearch {
    /**
     * points to note:
     * 1 ) Array should be sorted.
     * 2 ) Divide Array in to two part.
     *          a) lower half [low, mid]
     *          b) upper half [mid+1, high]
     * 3 ) Java compareTo.
     * 4 ) Time complexity : NlogN.
     *
     */
    public static int binarySearch (String [] array, String key , int low, int high) {
        int N = high-low;
        if (N<=1) return -1;
        int mid = low+(N)/2;
        System.out.println(mid+" "+array[mid]);
        int cmp = array[mid].compareTo(key);
        if (cmp > 0) return binarySearch(array,key,low,mid);
        else if (cmp < 0) return binarySearch(array, key, mid, high);
        else return mid;
    }
}
