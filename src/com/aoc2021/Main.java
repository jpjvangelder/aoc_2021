package com.aoc2021;

public class Main {

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println(day1.getTotalDeeperValues());
        System.out.println(day1.getTotalDeeperValuesMeasurementSlidingWindow(3));
    }
}
