package homework;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CountingSort {

    private int[] sort(int[] arr) {
        int max = getMax(arr);
        int min = getMin(arr);

        // k = max - min + 1 (using offset)
        int[] counter = new int[max - min + 1];

        // count repetitions of numbers in an array (using offset)
        // O(n)
        for (int i : arr) counter[i - min]++;

        int j = 0;

        // O(k)
        for (int i = 0; i < counter.length; i++) {
            for (int k = 0; k < counter[i]; k++) {
                arr[j++] = i + min;
            }
        }

        return arr;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }

        return min;
    }

    @Test
    public void testCases() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, sort(arr));

        arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        expected = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expected, sort(arr));

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, sort(arr));

        arr = new int[]{-1, -2, -3, 4, 5, 6, 7, 8, 9};
        expected = new int[]{-3, -2, -1, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, sort(arr));
    }
}
