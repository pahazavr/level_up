package homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Given a non-negative number. It is required to revert it
        - 103 -> 301
 */
public class Task_2 {

    // O(n)
    private static String revertInteger(int num) {
        StringBuilder result = new StringBuilder();
        char[] chars = String.valueOf(num).toCharArray();
        for(int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }
        return result.toString();
    }

    // O(n)
    private static String revertInteger_02(int num) {
        StringBuilder result = new StringBuilder();
        if(num == 0) return String.valueOf(num);
        while(num != 0) {
            result.append(num % 10);
            num /= 10;
        }
        return result.toString();
    }

    @Test
    public void testCases() {
        int num = 103;
        assertEquals("301", revertInteger(num));

        num = 0;
        assertEquals("0", revertInteger(num));

        num = 300;
        assertEquals("003", revertInteger(num));

        num = 111111;
        assertEquals("111111", revertInteger(num));

        num = 123456789;
        assertEquals("987654321", revertInteger(num));

        num = 103;
        assertEquals("301", revertInteger_02(num));

        num = 0;
        assertEquals("0", revertInteger_02(num));

        num = 300;
        assertEquals("003", revertInteger_02(num));

        num = 111111;
        assertEquals("111111", revertInteger_02(num));

        num = 123456789;
        assertEquals("987654321", revertInteger_02(num));
    }
}
