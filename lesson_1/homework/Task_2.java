package homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Given a non-negative number. It is required to revert it
        - 103 -> 301
 */
public class Task_2 {

    // O(n)
    private static int revertInteger(int num) {
        StringBuilder result = new StringBuilder();
        char[] chars = String.valueOf(num).toCharArray();
        for(int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }
        return Integer.parseInt(result.toString());
    }

    @Test
    public void testCases() {
        int num = 103;
        assertEquals(301, revertInteger(num));

        num = 111111;
        assertEquals(111111, revertInteger(num));

        num = 123456789;
        assertEquals(987654321, revertInteger(num));
    }
}
