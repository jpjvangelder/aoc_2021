package com.aoc2021;

import com.aoc2021.day1.Day1;
import com.aoc2021.day2.Day2;
import com.aoc2021.day3.Day3;

public class Main {

    public static void main(String[] args) {
        // Day 1 Output
        System.out.println("Day 1 Output");
        Day1 day1 = new Day1();

        System.out.println(day1.part1());
        System.out.println(day1.part2(3));

        System.out.println("\n");

        // Day 2 Output
        System.out.println("Day 2 Output");
        Day2 day2 = new Day2();

        System.out.println(day2.part1());
        System.out.println(day2.part2());

        System.out.println("\n");

        //Day 3 output
        Day3 day3 = new Day3();
        System.out.println("Day 3 Output");
        System.out.println(day3.part1());
    }
}
