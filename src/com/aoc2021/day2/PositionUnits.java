package com.aoc2021.day2;

public class PositionUnits {
    private String position;
    private Integer units;

    public PositionUnits(String position, Integer units) {
        this.position = position;
        this.units = units;
    }

    public String getPosition() {
        return position;
    }

    public Integer getUnits() {
        return units;
    }
}
