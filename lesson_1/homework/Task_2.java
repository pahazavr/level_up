package homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Given a non-negative number. It is required to revert it
        - 103 -> 301
 */
public class Task_2 {

    // O(1)
    private static int revertInteger(int num) {
        String n3 = String.valueOf(num % 10);
        String n2 = String.valueOf((num % 100) / 10);
        String n1 = String.valueOf(num / 100);

        return Integer.parseInt(n3 + n2 + n1);
    }

    @Test
    public void testCases() {
        int num = 103;
        assertEquals(301, revertInteger(num));

        num = 999;
        assertEquals(999, revertInteger(num));

        num = 111;
        assertEquals(111, revertInteger(num));
    }
}
