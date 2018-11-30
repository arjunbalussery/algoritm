package com.company;

public class MyThread implements Runnable{
    int [] array = new int[60];
    @Override
    public void run() {
        int i=0;
        while(true) {
            i=0;
            for (;i<60;i++) {
                System.out.println(i+"value: "+array[i]);
            }
        }
    }
}
