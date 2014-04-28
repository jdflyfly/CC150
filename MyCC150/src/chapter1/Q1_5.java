package chapter1;

public class Q1_5 {

    private static int countNewLen(String str) {
    
    
        return 0;
    }

    public static String compress(String str) {
        if (str == null || str.length() <= 2)
            return str;
        int newLen = countNewLen(str);
        if (newLen >= str.length())
            return str;

        return str;
    }

    public static void main(String[] args) {
        String str = "aaaaaaa";
        String str2 = compress(str);
        System.out.println("Compression: " + str);
        System.out.println("Old String (len = " + str.length() + "): " + str);
        System.out.println("New String (len = " + str2.length() + "): " + str2);

    }
}
