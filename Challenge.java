package com.codechallenge.may;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Challenge {

    public static void main(String[] args) {
        //findComplement(5);
        /*System.out.println(canConstruct("bcb",
                "cjjajdfaaeegig"));*/

        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums);
    }

    /**
     * Ransom Note
     * Solution
     * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
     * <p>
     * Each letter in the magazine string can only be used once in your ransom note.
     * <p>
     * Note:
     * You may assume that both strings contain only lowercase letters.
     * <p>
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] charArray = magazine.toCharArray();
        Map<String, Integer> magazineDictionary = new ConcurrentHashMap<>();
        Map<String, Integer> ransomDictionary = new ConcurrentHashMap<>();
        Integer initializer = 1;

        for (int index = 0; index < charArray.length; index++) {
            String key = String.valueOf(charArray[index]);
            if (magazineDictionary.get(key) != null) {
                Integer val = magazineDictionary.get(key);
                val = val + 1;
                magazineDictionary.put(key, val);
            } else {
                magazineDictionary.put(key, initializer);
            }
        }

        System.out.println(magazineDictionary.toString());

        charArray = ransomNote.toCharArray();
        for (int index = 0; index < charArray.length; index++) {
            String key = String.valueOf(charArray[index]);
            if (ransomDictionary.get(key) != null) {
                Integer val = ransomDictionary.get(key);
                val = val + 1;
                ransomDictionary.replace(key, val);
            } else {
                ransomDictionary.put(key, initializer);
            }
        }

        System.out.println(ransomDictionary.toString());

        AtomicBoolean isPossible = new AtomicBoolean(true);
        ransomDictionary.entrySet().forEach(stringIntegerEntry -> {
            String key = stringIntegerEntry.getKey();
            if (magazineDictionary.containsKey(key) && magazineDictionary.get(key) >= stringIntegerEntry.getValue()) {
                isPossible.set(true);
            } else {
                isPossible.set(false);
                return;
            }
        });

        return isPossible.get();
    }

    /**
     * Number Complement
     * Solution
     * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
     * Example 1:
     * Input: 5
     * Output: 2
     * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {

        String binaryValue = Integer.toBinaryString(num);
        String toBinary = "";

        for (int i = 0; i < binaryValue.length(); i++) {
            if (binaryValue.charAt(i) == '0') {
                toBinary = toBinary + "1";
            } else if (binaryValue.charAt(i) == '1') {
                toBinary = toBinary + "0";
            }
        }

        return Integer.parseInt(toBinary, 2);
    }

    /**
     * First Unique Character in a String
     * Solution
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * <p>
     * Examples:
     * <p>
     * s = "leetcode"
     * return 0.
     * <p>
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();

        for (int currentIndex = 0; currentIndex < charArray.length; currentIndex++) {
            char search = charArray[currentIndex];

            int lastIndex = s.lastIndexOf(search);
            int firstIndex = s.indexOf(search);
            if (lastIndex == currentIndex && (lastIndex == firstIndex)) {
                return currentIndex;
            }
        }
        return -1;
    }

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> magazineDictionary = new ConcurrentHashMap<>();
        Integer initializer = 1;
        Integer maxValue = 0;
        Integer maxKey = 0;

        for (int index = 0; index < nums.length; index++) {
            Integer key = nums[index];
            if (magazineDictionary.get(key) != null) {
                Integer val = magazineDictionary.get(key);
                val = val + 1;
                magazineDictionary.put(key, val);
                if (val > maxValue) {
                    maxValue = val;
                    maxKey = key;
                }
            } else {
                magazineDictionary.put(key, initializer);
                if (initializer > maxValue) {
                    maxValue = initializer;
                    maxKey = key;
                }
            }
        }
        return maxKey;

    }
}