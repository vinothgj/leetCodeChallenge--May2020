package com.codechallenge.may;


public class Challenge {

    public static void main(String[] args) {

    }

    public int findComplement(int num) {

        String binaryValue = Integer.toBinaryString(num);
        char[] binaryValueArray = binaryValue.toCharArray();
        String toBinary = "";

        for (int i = 0; i < binaryValueArray.length; i++) {
            if (binaryValueArray[i] == 0) {
                toBinary += "1";
            } else {
                toBinary += "0";
            }
        }

        //String returnValue = Integer.toBinaryString(Integer.parseInt(toBinary));

        return Integer.parseInt(Integer.toBinaryString(Integer.parseInt(toBinary)));
    }

    /**
     * First Unique Character in a String
     * Solution
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     *
     * Examples:
     *
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.  
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