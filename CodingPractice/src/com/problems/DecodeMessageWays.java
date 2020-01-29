package com.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeMessageWays {
    private static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        System.out.println(noOfWays("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
    }

    private static void fillMap() {

        for (int key = 1; key <= 26; key++) {
            char value = (char) (key + 64);
            map.put(key, value);
        }
    }

    private static int noOfWays(String word) {
        Set<String> set = new HashSet<>();
        noOfWays("", word, set);
        return set.size();
    }

    private static void noOfWays(String decodedWord, String remainingWord, Set<String> set) {
        if (remainingWord.startsWith("0"))
            return;

        if (remainingWord.equals("")) {
            System.out.println(decodedWord);
            set.add(decodedWord);
            return;
        }

        Character decodedChar = getDecodedWord(remainingWord, 1);
        //append decodedChar if not null
        String dw1 = decodedWord + decodedChar;
        String rw1 = getRemainingWord(remainingWord, 1);
        noOfWays(dw1, rw1, set);

        if (remainingWord.length() > 1) {
            decodedChar = getDecodedWord(remainingWord, 2);
            if (decodedChar != null) {
                String dw2 = decodedWord + decodedChar;
                String rw2 = getRemainingWord(remainingWord, 2);
                noOfWays(dw2, rw2, set);
            }
        }
    }

    private static String getRemainingWord(String remainingWord, int i) {
        return remainingWord.substring(i);
    }

    private static Character getDecodedWord(String remainingWord, int i) {
        int key = Integer.parseInt(remainingWord.substring(0, i));
        return map.get(key);
    }
}