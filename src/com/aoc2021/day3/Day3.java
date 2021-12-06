package com.aoc2021.day3;

import com.aoc2021.util.Constants;
import com.aoc2021.util.ListUtil;

import java.util.List;

public class Day3 {
    private List<byte[]> input = ListUtil.getCharsFromFile(Constants.DAY_3);
    private StringBuilder gammaRate = new StringBuilder();
    private StringBuilder epsilonRate = new StringBuilder();

    public int part1() {
        for (int i = 0; i < input.get(0).length; i++) {
            BitCalculus bitCalculus = calculateBits(input, i);

            gammaRate.append(bitCalculus.getZeroBits() > bitCalculus.getOneBits() ? 0 : 1);
            epsilonRate.append(bitCalculus.getZeroBits() < bitCalculus.getOneBits() ? 0 : 1);
        }

        return Integer.parseInt(epsilonRate.toString(), 2) * Integer.parseInt(gammaRate.toString(), 2);
    }

    private BitCalculus calculateBits(List<byte[]> input, int pointer) {
        int zeroBits = 0;
        int oneBits = 0;

        for (byte[] bytes : input) {
            switch (bytes[pointer]) {
                case 48 -> zeroBits++;
                case 49 -> oneBits++;
            }
        }

        return new BitCalculus(zeroBits, oneBits);
    }
}

