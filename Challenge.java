package com.codechallenge.may;


public class Challenge {

    public static void main(String[] args) {
        findComplement(5);
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
}