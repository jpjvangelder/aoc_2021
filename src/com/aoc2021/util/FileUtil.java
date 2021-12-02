package com.aoc2021.util;

import com.aoc2021.day2.PositionUnits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
    public static List<Integer> getIntegerListFromFile(String path) {
        List<Integer> integers = new ArrayList<>();

        try {
            integers = convertStringListToIntegerList(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return integers;
    }

    public static List<PositionUnits> getMapFromFile(String path) {
        List<PositionUnits> positionUnits = new ArrayList<>();

        try {
            positionUnits = convertFileToMap(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return positionUnits;
    }

    private static List<PositionUnits> convertFileToMap(String path) throws IOException {
        return convertFileToList(path).stream()
                .map(s -> s.split("\s(?=([^\"]*\"[^\"]*\")*[^\"]*$)"))
                .map(split -> new PositionUnits(split[0], Integer.parseInt(split[1])))
                .collect(Collectors.toList());
    }

    private static List<Integer> convertStringListToIntegerList(String path) throws IOException {
        return convertFileToList(path).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static List<String> convertFileToList(String path) throws IOException {
        return Files.lines(Paths.get(path)).map(Object::toString).collect(Collectors.toList());
    }
}
