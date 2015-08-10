package epi.ch7strings;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamaaref on 07/08/15.
 */
public class SpreadsheetColumnEncoding {

    /**
     * BZ = B*26^1 + Z = 2 * 26^1 + 26
     * @param columnValue
     */
    public static int getColumnInteger(String columnValue) {
        int result = 0;
        int power = 0;

        for (int i = columnValue.length()-1; i >=0; i--) {
            result += (columnValue.charAt(i) - 'A' + 1) * Math.pow(26, power++);
        }

        return result;
    }

    @Test
    public void test() {
        assertEquals(1, getColumnInteger("A"));
        assertEquals(4, getColumnInteger("D"));
        assertEquals(27, getColumnInteger("AA"));
        assertEquals(702, getColumnInteger("ZZ"));
    }
}
