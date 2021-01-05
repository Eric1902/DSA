package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

public class SongPair {

    public static void main(String[] args) {
        System.out.println(getPairCount(new int[]{30, 60}));
        System.out.println(getPairCount(new int[]{30, 60, 90}));
        System.out.println(getPairCount(new int[]{30, 60, 90, 60}));
        System.out.println(getPairCount(new int[]{30, 60, 90, 30}));
        System.out.println(getPairCount(new int[]{30, 30}));
        System.out.println(getPairCount(new int[]{30, 30, 30}));
        System.out.println(getPairCount(new int[]{30, 30, 30, 30}));
        System.out.println(getPairCount(new int[]{30, 20, 150, 100, 40}));
        System.out.println(getPairCount(new int[]{60, 60, 60}));
    }

    private static int getPairCount(int[] songs) {

        int result = 0;
        Map<Integer, Integer> memory = new HashMap<>();

        for (int song : songs) {
            song = song % 60;

            int myPair = (60 - song) % 60;
            if (memory.containsKey(myPair)) {
                int currentValue = memory.get(myPair);
                result += currentValue;
                memory.put(song, currentValue + 1);
            } else {
                memory.put(song, 1);
            }
        }

        return result;
    }
}
