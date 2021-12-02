package com.aoc2021;

import com.aoc2021.day1.Day1;
import com.aoc2021.day2.Day2;

public class Main {

    public static void main(String[] args) {
        // Day 1 Output
        System.out.println("Day 1 Output");
        Day1 day1 = new Day1();

        System.out.println(day1.getTotalDeeperValues());
        System.out.println(day1.getTotalDeeperValuesMeasurementSlidingWindow(3));

        System.out.println("\n");

        // Day 2 Output
        System.out.println("Day 2 Output");
        Day2 day2 = new Day2();

        System.out.println(day2.calculatePlannedCourse());
        System.out.println(day2.calculatePlannedCourseExpanded());
    }
}
