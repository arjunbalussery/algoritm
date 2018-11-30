package com.company;

import java.util.Random;

public class StringGenerator {
    public static String [] generator (int numberOfStrings, String word) {
        Random rn = new Random();
        String [] strArray = new String[numberOfStrings];
        for (int i=0;i<numberOfStrings;i++) {
            char [] temp = new char[word.length()];
            for (int j=0;j<word.length();j++) {
                char ch = word.charAt(rn.nextInt(word.length()-1));
                temp[j] = ch;
            }
            strArray[i] = new String(temp);;
        }
        return strArray;
    }
}
