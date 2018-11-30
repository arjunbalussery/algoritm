package com.company;

import java.util.HashMap;
import java.util.Map;

public class Array {
    public static int findcount(int[] array, int total) {
        return findCount(array,total,0, 0);
    }

    private static int findCount(int[] array, int total, int sum, int index) {
        if (total==sum)
            return 1;
        if (sum > total)
            return 0;
        if (index >= array.length )
            return 0;
        return findCount(array,total,sum+array[index],index+1)+
                findCount(array,total,sum,index+1);
    }

    public static int editString(String str1, String str2) {
        Map<String,Integer> mem = new HashMap<>();
        return editString(str1,str2,str1.length(),str2.length(),mem);
        //return editString(str1,str2,str1.length(),str2.length());
    }

    private static int editString(String str1, String str2, int m, int n, Map<String,Integer> mem) {
        String key = m+":"+n;
        int op=0;
        if (m==0)
            return n;
        if (n==0)
            return m;
        if (mem.get(key) != null) {
            return mem.get(key);
        }
        if(str1.charAt(m-1)==str2.charAt(n-1)) {
            op = editString(str1,str2, m-1, n-1,mem);
        } else {
            op = 1+min(editString(str1,str2,m,n-1,mem),editString(str1,str2,m-1,n,mem),editString(str1,str2,m-1,n-1,mem));
        }
        mem.put(key,op);
        return op;
    }

    private static int editString(String str1, String str2, int m, int n) {
        int op=0;
        if (m==0)
            return n;
        if (n==0)
            return m;
        if(str1.charAt(m-1)==str2.charAt(n-1)) {
            op = editString(str1,str2, m-1, n-1);
        } else {
            op = 1+min(editString(str1,str2,m,n-1),editString(str1,str2,m-1,n),editString(str1,str2,m-1,n-1));
        }
        return op;
    }
    private static int min (int x, int y, int z){
        if(x<y && x<z)
            return x;
        if(y<x && y<z)
            return y;
        return z;
    }
}
