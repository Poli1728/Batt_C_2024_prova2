package it.unical.demacs;

import java.util.HashMap;
import java.util.Map;

public class Algorithms {

    /**
     * Sorts a given non-null array
     *
     * @param array to be ordered
     * @throws IllegalArgumentException if the input array is null
     */
    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Checks if two given strings are Anagrams
     *
     * @param first
     * @param second
     * @return a boolean value
     * @throws IllegalArgumentException if one of the strings is null
     */
    public boolean areAnagrams(String first, String second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Strings cannot be null");
        }

        if (first.length() != second.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : first.toLowerCase().toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : second.toLowerCase().toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            }

            int count = charCount.get(c);

            if (count == 0) {
                return false;
            }

            charCount.put(c, count - 1);
        }

        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}