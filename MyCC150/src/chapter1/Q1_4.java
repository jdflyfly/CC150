package chapter1;

/**
 * Write a method to replace all spaces in a string with ‘%20’. (Assume string
 * has sufficient free space at the end)
 * 
 * @author jd
 * 
 */
public class Q1_4 {

    /**
     * 1. Count the number of spaces during the first scan of the string. 
     * 2.Parse the string again from the end and for each character: 
     * if a space is encountered, store '%20';
     * else store the character as it is in the newly shifted location.
     */
    public static void replaceSpaces(char[] str, int length) {
        if (str == null)
            return;
        int spaceCount = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }
        int newLength = length + 2 * spaceCount;
        for (int i = length - 1, j = newLength - 1; i >= 0 && j >= 0; i--) {
            if (str[i] != ' ') {
                str[j--] = str[i];
            } else {
                str[j--] = '0';
                str[j--] = '2';
                str[j--] = '%';
            }

        }

    }

    public static void main(String[] args) {
        String str = "abc d e f";
        char[] arr = new char[str.length() + 3 * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        replaceSpaces(arr, str.length());
        System.out.println("\"" + new String(arr) + "\"");
    }
}
