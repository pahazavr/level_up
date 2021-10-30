package homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Given n > 2 dimensional array of numbers from 0 and 1.
    Guaranteed to be as at least one 1 and one 0.
    It is required to find the maximum distance from 1.
 */
public class Task_5 {

    // O(n)
    private static int calcBestDistance(int[] arr) {
        int result = 0;
        int temp = 0;
        boolean fromStart;

        for (int i = 0; i < arr.length; i++) {
            fromStart = i == 0;

            // search for consecutive 0
            while (i < arr.length && arr[i] == 0) {
                temp++;
                i++;
            }

            // if the current sequence 0 is not at the beginning and not at the end of the array,
            // then it is required to divide its length in half (with rounding up)
            if (!fromStart && i != arr.length) {
                temp = temp / 2 + temp % 2;
            }

            if (result < temp) result = temp;
            temp = 0;
        }

        return result;
    }

    @Test
    public void testCalculations() {
        int[] a = {1, 0};
        assertEquals(1, calcBestDistance(a));

        a = new int[]{1, 0, 1};
        assertEquals(1, calcBestDistance(a));

        // в конце 0
        a = new int[]{1, 0, 1, 0, 0};
        assertEquals(2, calcBestDistance(a));

        // в начале 0
        a = new int[]{0, 0, 1, 0, 1};
        assertEquals(2, calcBestDistance(a));

        // в середине, нечетное
        a = new int[]{1, 0, 1, 0, 0, 0, 1};
        assertEquals(2, calcBestDistance(a));

        // в середине, четное
        a = new int[]{1, 0, 1, 0, 0, 0, 0, 1};
        assertEquals(2, calcBestDistance(a));

        // если внутри
        a = new int[]{1, 0, 0, 0, 0, 0, 1};
        assertEquals(3, calcBestDistance(a));

        // если с 0
        a = new int[]{0, 0, 0, 0, 1};
        assertEquals(4, calcBestDistance(a));

        // если с 1
        a = new int[]{1, 0, 0, 0, 0};
        assertEquals(4, calcBestDistance(a));

        // равнозначные варианты
        a = new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        assertEquals(5, calcBestDistance(a));
    }
}
