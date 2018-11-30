package com.company;

import java.util.LinkedList;
import java.util.List;

public class Dice {
    static int call=0;
    public static void dice(int n) {
        List<Integer> list = new LinkedList<>();
        dice(n,list);
    }

    public static void diceDiff(int n) {
        diceDiff(n,"");
    }

    private static void diceDiff(int n, String prefix) {
        if(n==0) {
            System.out.println(prefix);
        } else {
            for(int i=1;i<=6;i++) {
                diceDiff(n-1,prefix+","+i);
            }
        }

    }

    public static void diceSum(int n, int sum) {
        List<Integer> list = new LinkedList<>();
        diceSum(n,sum,0,list);
    }

    private static void diceSum(int n, int sum, int sumSofar, List<Integer> list) {
        if(n==0) {
          //if (sum==sumSofar) {
              list.forEach(x-> System.out.print(x+","));
              System.out.println();
         // }
        }else {
            for(int i=1;i<=6;i++) {
                if(sumSofar+i+(n-1)*1<=sum
                        && sumSofar+i+(n-1)*6 >= sum) {
                    //choose
                    list.add(i);
                    //explore
                    diceSum(n-1,sum,sumSofar+i,list);
                    //unchose
                    list.remove(list.size()-1);
                }

            }
        }
    }

    private static void dice(int n, List<Integer> list) {
        if (n==0) {
            list.forEach(x-> System.out.print(x+","));
            System.out.println();
        } else {
            for(int i=1;i<=6;i++) {
                //chose
                list.add(i);
                //explore
                dice(n-1,list);
                //unchose
                list.remove(list.size()-1);
            }
        }
    }

    public static void printBinary(int n) {
        call=0;
        List<Integer> list = new LinkedList<>();
        printBinary(n,list);
        System.out.println("call: "+call);
    }

    private static void printBinary(int n, List<Integer> list) {
        call++;
        if(n==0) {
            list.forEach(x-> System.out.print(x+" "));
            System.out.println();
        } else {
            for (int i=0;i<2;i++) {
                //chose
                list.add(i);
                //explore
                printBinary(n-1,list);
                //unchose
                list.remove(list.size()-1);
            }
        }
    }

    public static void printBinaryDiff(int n) {
        call=0;
        printBinaryDiff(n,"");
        System.out.println("call: "+call);
    }

    private static void printBinaryDiff(int n, String prefix) {
        call++;
        if (n==0) {
            System.out.println(prefix);
        } else {
            for (int i=0;i<2;i++) {
                printBinaryDiff(n-1,prefix+i);
            }
            //printBinaryDiff(n-1,prefix+"0");
            //printBinaryDiff(n-1,prefix+"1");
        }
    }
}
