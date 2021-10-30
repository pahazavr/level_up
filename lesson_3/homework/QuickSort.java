package homework;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSort {

    private static int[] sort(int[] arr, int start, int end) {
        if (start <= end) {
            int p = partition(arr, start, end);
            sort(arr, start, p - 1);
            sort(arr, p + 1, end);
        }
        return arr;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];             // pivot element
        int i = start - 1;                  // the index where the elements that are less than the pivot will be added
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);          // setting the pivot element to the position in which it should be

        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    @Test
    public void testCases() {
        int[] arr = {8, 7, 2, 1, 4, 5, 9, 3};
        int[] expected = {1, 2, 3, 4, 5, 7, 8, 9};
        assertArrayEquals(expected, sort(arr, 0, arr.length - 1));

        arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        expected = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expected, sort(arr, 0, arr.length - 1));

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, sort(arr, 0, arr.length - 1));
    }
}
