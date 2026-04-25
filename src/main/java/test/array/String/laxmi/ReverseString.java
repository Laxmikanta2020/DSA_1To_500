package test.array.String.laxmi;

public class ReverseString {
    public static void main(String[] args) {

        String str = "Reverse string without library";
        char[] charArray = str.toCharArray();
        int x = 0;
        int y = charArray.length - 1;
        while (x < y) {
            char c = charArray[x];
            charArray[x] = charArray[y];
            charArray[y] = c;
            x++;
            y--;

        }
        System.out.println(new String(charArray));

    }

    public static String reverse(String str) {


        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);

    }
}
// 18-01-2026
// By LK ✦