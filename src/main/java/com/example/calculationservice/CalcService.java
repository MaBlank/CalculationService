package com.example.calculationservice;

public class CalcService {
    public int[] calculateExpectedValues(int a, int b, int c, int d) {
        int[] result = new int[4];
        result[0] = (a * 2) + 1; // E
        result[1] = (b * 2) + 1; // F
        result[2] = (c * 2) + 1; // G
        result[3] = (d * 2) + 1; // H
        return result;
    }
}
