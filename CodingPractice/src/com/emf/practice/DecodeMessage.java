package com.emf.practice;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
    private static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        printNoOfWays("123");
    }

    private static void fillMap() {

        for (int key = 1; key <= 26; key++) {
            char value = (char) (key + 64);
            map.put(key, value);
        }
    }

    private static void printNoOfWays(String word) {
        printNoOfWays("", word);
    }

    private static void printNoOfWays(String decodedWord, String remainingWord) {
        if (remainingWord.equals("")) {
            System.out.println(decodedWord);
            return;
        }

        Character decodedChar = getDecodedWord(decodedWord, remainingWord, 1);
        String dw1 = decodedWord + decodedChar;
        String rw1 = getRemainingWord(remainingWord, 1);
        printNoOfWays(dw1, rw1);

        if (remainingWord.length() > 1) {
            decodedChar = getDecodedWord(decodedWord, remainingWord, 2);
            if (decodedChar != null) {
                String dw2 = decodedWord + decodedChar;
                String rw2 = getRemainingWord(remainingWord, 2);
                printNoOfWays(dw2, rw2);
            }
        }
    }

    private static String getRemainingWord(String remainingWord, int i) {
        return remainingWord.substring(i);
    }

    private static Character getDecodedWord(String decodedWord, String remainingWord, int i) {
        int key = Integer.parseInt(remainingWord.substring(0, i));
        return map.get(key);
    }
}

