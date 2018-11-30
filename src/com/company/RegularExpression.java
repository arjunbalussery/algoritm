package com.company;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void count() {
        Pattern pattern = Pattern.compile("^foo$");
        Matcher matcher = pattern.matcher("foo");
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }

        System.out.println(matches);
    }

    public static int getCount(String str, List<String> keywords) {
        int matches = 0;
        for (String key : keywords) {
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                matches++;
            }
        }
       return matches;

    }
}
