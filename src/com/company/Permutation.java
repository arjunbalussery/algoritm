package com.company;

import java.util.List;
import java.util.Set;

public class Permutation {
    public static void permute(List<String> list , List<String> choosen) {
        if (list.isEmpty()) {
            print(choosen);
        } else {
            for (int i=0;i<list.size();i++) {
                //choose
                String str = list.get(i);
                list.remove(i);
                choosen.add(str);
                //explore
                permute(list,choosen);
                //unchoose
                list.add(i,str);
                choosen.remove(choosen.size()-1);
                //subset(list,choosen);
            }
        }
    }

    private static void print(List<String> choosen) {
        for (String str : choosen) {
            System.out.print(str+" ");
        }
        System.out.println();
    }



}
