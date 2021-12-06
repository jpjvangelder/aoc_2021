package com.aoc2021.util;

import com.aoc2021.day2.PositionUnits;

import java.util.List;
import java.util.stream.Collectors;

import static com.aoc2021.util.FileUtil.readFileToList;

public class ListUtil {
    public static List<Integer> getIntegerListFromFile(String path) {
        return readFileToList(path).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<PositionUnits> getPositionUnitsFromFile(String path) {
        return readFileToList(path).stream()
                .map(s -> s.split("\s(?=([^\"]*\"[^\"]*\")*[^\"]*$)"))
                .map(split -> new PositionUnits(split[0], Integer.parseInt(split[1])))
                .collect(Collectors.toList());
    }

    public static List<byte[]> getCharsFromFile(String path) {
        return readFileToList(path).stream().map(String::getBytes).collect(Collectors.toList());
    }

}
