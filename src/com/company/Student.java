package com.company;

public class Student {
    private Integer year;
    private Double mark;

    public Student(Integer year, Double mark) {
        this.year = year;
        this.mark = mark;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "year=" + year +
                ", mark=" + mark +
                '}';
    }
}
