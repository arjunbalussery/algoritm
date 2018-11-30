package com.company;

public class MyString {
    public static void printSubString(String str){
            printSubString(str,0,0);

    }

    private static void printSubString(String str, int i, int j) {
        if (i >= str.length() && j >= str.length()) {
            return;
        }
        if(i<str.length() && j<str.length()) {
            printSubString(str,i,++j);
        } else if(i<str.length() && j>=str.length()) {
            i=i+1;
            printSubString(str,i,i);
        }
    }
}
