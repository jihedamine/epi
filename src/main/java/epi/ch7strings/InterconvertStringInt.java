package epi.ch7strings;

/**
 * Created by jamaaref on 07/08/15.
 */
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class InterconvertStringInt {

    public static int stringToInteger(String str) {
        int result = 0;
        int i = 0;

        boolean isNegative = (str.charAt(0) == '-');
        if (isNegative) i++;

        while (i < str.length()) {
            result *= 10;
            result += (str.charAt(i) - '0');
            i++;
        }

        if (isNegative) result *= -1;

        return result;
    }

    public static String integerToString(int value) {
        StringBuilder result = new StringBuilder();

        int valueToProcess = value;
        boolean isNegative = value < 0;
        if (isNegative) valueToProcess *= -1;

        while (valueToProcess > 0) {
            int digit = valueToProcess % 10;
            result.append(digit);
            valueToProcess = valueToProcess / 10;
        }

        if (isNegative) result.append('-');

        return result.reverse().toString();
    }

    @Test
    public void test() {
        Random random = new Random();
        int value = random.nextInt();

        assertEquals(value, stringToInteger(String.valueOf(value)));
        assertEquals(String.valueOf(value), integerToString(value));
    }
}
