package chapter1;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring.
 * 
 * @author Dong Jiang
 * 
 */
public class Q1_8 {

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    /**
     * concatenate s1 with itself and see whether s2 is substring of the result.
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isRotation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == len2) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "bottlewater";
        System.out.println(isRotation(s1, s2));
    }
}
