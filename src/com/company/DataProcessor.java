package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataProcessor {
    private int currentValue=0;
    public void process() {
        List<Student> students= new ArrayList<>();
        students.add(new Student(2011,48.0));
        students.add(new Student(2011,50.0));
        students.add(new Student(2011,30.0));
        students.add(new Student(2013,48.0));
        /*students.sort((s1,s2)->s2.getMark().compareTo(s1.getMark()));
        students.forEach(s-> System.out.println(s));*/
        Tester.print();
        students.forEach(s-> System.out.println(currentValue++) );
    }
}
