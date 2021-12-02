package com.aoc2021.day1;

import com.aoc2021.util.Constants;
import com.aoc2021.util.FileUtil;

import java.util.List;

public class Day1 {
    private final List<Integer> integers;
    private int totalDeeperValues;
    private int previousValue;
    private int currentValue;

    public Day1() {
        integers = FileUtil.getIntegerListFromFile(Constants.DAY_1);
        totalDeeperValues = 0;
        previousValue = 0;
        currentValue = 0;
    }

    public int getTotalDeeperValues() {
        resetValues();

        for (int i = 0; i < integers.size(); i++) {
            currentValue = integers.get(i);
            if (i != 0) {
                if (currentValue > previousValue) totalDeeperValues++;
            }
            previousValue = currentValue;
        }

        return totalDeeperValues;
    }

    public int getTotalDeeperValuesMeasurementSlidingWindow(int measurementWindow) {
        resetValues();

        for (int i = 0; i < integers.size(); i++) {
            if (i + measurementWindow <= integers.size()) {
                for (int j = 0; j < measurementWindow; j++) currentValue += integers.get(i + j);

                if (i != 0) if (currentValue > previousValue) totalDeeperValues++;

                previousValue = currentValue;
                currentValue = 0;
            }

        }

        return totalDeeperValues;
    }

    private void resetValues() {
        previousValue = 0;
        totalDeeperValues = 0;
        currentValue = 0;
    }
}
