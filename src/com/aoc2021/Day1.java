package com.aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    String path = "src/resources/input_day1.txt";

    public int getTotalDeeperValues() {
        List<Integer> integers = getIntegerListFromFile(path);
        int previousValue = 0;
        int totalDeeperValues = 0;
        int currentValue;

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
        List<Integer> integers = getIntegerListFromFile(path);
        int totalDeeperValues = 0;
        int previousValue = 0;
        int currentValue = 0;

        for (int i = 0; i < integers.size(); i++) {
            if(i + measurementWindow <= integers.size()){
                for (int j = 0; j < measurementWindow; j++) currentValue += integers.get(i + j);

                if (i != 0) if (currentValue > previousValue) totalDeeperValues++;

                previousValue = currentValue;
                currentValue = 0;
            }

        }

        return totalDeeperValues;
    }

    private List<Integer> getIntegerListFromFile(String path) {
        List<Integer> integers = new ArrayList<>();

        try {
            integers = convertFileToArray(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return integers;
    }

    private List<Integer> convertFileToArray(String path) throws IOException {
        return Files.lines(Paths.get(path)).map(Integer::parseInt).collect(Collectors.toList());
    }
}
