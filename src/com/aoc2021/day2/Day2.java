package com.aoc2021.day2;

import com.aoc2021.util.Constants;
import com.aoc2021.util.FileUtil;

import java.util.List;

public class Day2 {
    List<String> testValues = List.of("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");
    private final List<PositionUnits> mapFromFile;
    private int horizontalPostition;
    private int depth;
    private int aim;

    public Day2() {
        mapFromFile = FileUtil.getMapFromFile(Constants.DAY_2);
        horizontalPostition = 0;
        depth = 0;
        aim = 0;
    }

    public int calculatePlannedCourse() {
        resetValues();

        mapFromFile.forEach(positionUnits -> {
            switch (positionUnits.getPosition()) {
                case "forward" -> horizontalPostition += positionUnits.getUnits();
                case "down" -> depth += positionUnits.getUnits();
                case "up" -> depth -= positionUnits.getUnits();
            }
        });

        return horizontalPostition * depth;
    }

    public int calculatePlannedCourseExpanded() {
        resetValues();

        mapFromFile.forEach(positionUnits -> {
            switch (positionUnits.getPosition()) {
                case "down" -> aim += positionUnits.getUnits();
                case "up" -> aim -= positionUnits.getUnits();
                case "forward" -> {
                    horizontalPostition += positionUnits.getUnits();
                    depth += aim * positionUnits.getUnits();
                }
            }
        });

        return horizontalPostition * depth;
    }

    private void resetValues() {
        horizontalPostition = 0;
        depth = 0;
    }
}
