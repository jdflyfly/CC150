package chapter1;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 * 
 * @author jd
 * 
 */
public class Q1_1 {

    /**
     * if the char set is extended ASCII(256 characters).
     * 
     * Time complexity is O(n), where n is the length of the string, and space
     * complexity is O(1).
     * 
     */
    public static boolean isUniqueChars(String str) {
        if (str == null || str.length() <= 1)
            return true;

        boolean[] exist = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            if (exist[str.charAt(i)] == false)
                exist[str.charAt(i)] = true;
            else
                return false;
        }
        return true;

    }

    /**
     * we can reduce the space usage by using a bit vector
     * 
     */
    public static boolean isUniqueChars2(String str) {
        if (str == null || str.length() <= 1)
            return true;
        byte[] exist = new byte[32];
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i);
            if ((exist[idx / 8] & (1 << (idx % 8))) == 0)
                exist[idx / 8] |= 1 << (idx % 8);
            else
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String[] words = { "abcde", "hello", "apple", "kite", "padle", "aa", "abba" };
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
        }
    }

    /**
     * alternative solutions: 
     * 1. Check each char of the string with every other
     * char of the string for duplicate occurrences. This will take O(n^2) and
     * no space. 
     * 2. If we are allowed to destroy the string, we can sort the
     * chars in the string in O(nlogn) time and linearly check the string for
     * neighboring chars that are identical. 
     */

}
