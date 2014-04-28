package chapter1;

/**
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author jd
 * 
 */
public class Q1_3 {
    /**
     * Assume the char set is extended ASCII, we check whether the two string
     * have identical counts for each char.
     */
    static boolean permutation(String a, String b) {
        if (a == null)
            return b == null;
        int[] count = new int[256];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
        }

        //this part is so nice
        for (int i = 0; i < b.length(); i++) {
            count[b.charAt(i)]--;
            if (count[b.charAt(i)] < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = { { "apple", "papel" }, { "carrot", "tarroc" }, { "hello", "llloh" } };
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

}
