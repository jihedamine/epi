package epi.ch7strings;

/**
 * Created by jamaaref on 07/08/15.
 */
public class ReplaceAndRemove {

    /**
     * Write a program which takes as input a string s, and removes each "b" and replaces each "a" by "dd". Assume s is stored in an array that has enough space for the final result.
     * 'vbeaeba' => 'veddedd'
     */
    public static void replaceAndRemove(char[] string, int length) {
        int totalLength = length;
        int i = 0;
        do {
            if (string[i] == 'b') {
                totalLength--;
                for (int j = i; j < totalLength; j++) {
                    string[j] = string[j + 1];
                }
            } else if (string[i] == 'a') {
                totalLength++;
                for (int j = totalLength; j > i+1; j--) {
                    string[j] = string[j-1];
                }
                string[i] = 'd';
                string[i+1] = 'd';
                i+=2;
            } else {
                i++;
            }
        } while (i < totalLength);

        for (int x=0; x < totalLength; x++) {
            System.out.print(string[x]);
        }
    }

    public static void main(String[] args) {
        char[] expandedChars = new char[40];
        char[] chars = "vbeaeba".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            expandedChars[i] = chars[i];
        }

        replaceAndRemove(expandedChars, chars.length);
    }
}
