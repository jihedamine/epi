package epi.ch7strings;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamaaref on 07/08/15.
 *
 * "a(k-1)a(k-2)...a(1)a(0)", where 0 <= a(i) < b denotes in base b the integer a(k-1)*b^(k-1) + ... + a(1)*b^1 + a(0)*b^0
 *
 * "A" = 10, "B" = 11...
 *
 * "615", b1=7, b2=13 => result="1A7", since 6*7^2 + 1*7 + 5 = 1*13^2 + 10*13 + 7
 */
public class BaseConversion {

    public static String convertBase(String srcStr, int srcBase, int targetBase) {
        int value = 0;

        int pos = 0;

        for (int i = srcStr.length()-1; i >= 0; i--) {
            value += (srcStr.charAt(i) - '0') * Math.pow(srcBase, pos++);
        }

        StringBuilder result = new StringBuilder();

        int valueToProcess = value;
        while (valueToProcess > 0) {
            int digit = valueToProcess % targetBase;
            valueToProcess = valueToProcess / targetBase;
            result.append(toTargetBase(digit));
        }

        return result.reverse().toString();
    }

    private static char toTargetBase(int digit) {
        if (digit < 10) {
            return (char)('0' + digit);
        }

        return (char)('A' + digit - 10);
    }

    @Test
    public void test() {
        assertEquals("1A7", convertBase("615", 7, 13));
    }

}
