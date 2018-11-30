package com.company;

import com.sun.corba.se.impl.protocol.giopmsgheaders.LocateReplyMessage_1_1;

import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static final String MOVIE = "CHECKIT";
    private static final int VIEWS = 100_000;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
     /* List<String> list = new ArrayList<>();
      list.add("Luke");
      list.add("jude");
      list.removeIf(str->Character.isLowerCase(str.charAt(0)));
      list.forEach(System.out :: println);*/
    List<Student> list = Arrays.asList(
              new Student(2013,50.0),
              new Student(2014,40.0),
              new Student(2013,60.0),
              new Student(2014,40.0));
        IntStream.iterate(100, e->e).filter(e->e%2==0).limit(10).forEach(System.out :: print);
        System.out.println(list.stream().
                collect(Collectors
                        .groupingBy(Student :: getYear, Collectors
                                .mapping(s->s.getMark()+"_"+s.getYear(), Collectors.toList()))));
        Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
        System.out.println(nonEmptyOtionalGender);
        System.out.println(nonEmptyOtionalGender.flatMap(Function.identity()));
        System.out.println(nonEmptyOtionalGender.flatMap(gender->gender).orElse(""));
        list.stream()
    }
}
