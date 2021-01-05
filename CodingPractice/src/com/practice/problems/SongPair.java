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
        System.out.println(getPairCount(new int[]{174, 188, 377, 437, 54, 498, 455, 239, 183, 347, 59, 199, 52, 488, 147, 82}));
    }

    private static int getPairCount(int[] songs) {

        int result = 0;
        Map<Integer, Integer> memory = new HashMap<>();

        for (int song : songs) {

            int normalizedSong = song % 60;
            int myPair = (60 - normalizedSong) % 60;

            if (memory.containsKey(myPair)) {
                int currentValue = memory.get(myPair);
                result += currentValue;
            }

            if(memory.containsKey(normalizedSong))
                memory.put(normalizedSong, memory.get(normalizedSong)+1);
            else
                memory.put(normalizedSong, 1);

        }

        return result;
    }
}
