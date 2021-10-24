package homework;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
    Shift the array cyclically by positions to the left
        - shift by 2 { 1, 2, 3, 4, 5 } -> { 3, 4, 5, 1, 2 }
        - shift by 6 { 1, 2, 3, 4, 5 } -> { 2, 3, 4, 5, 1 }
 */
public class Task_4 {

    // O(n^2)
    private static double[] shiftLeft(double[] arr, int shift) {
        shift %= arr.length;
        double temp;

        // brute-force
        while(shift > 0) {
            // store the first element of the original array
            temp = arr[0];

            // shift the elements of the original array to the left by 1
            for(int i = 0;i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }

            // replace the last element of the original array with first element
            arr[arr.length - 1] = temp;
            shift--;
        }

        return arr;
    }

    // O(n)
    private static double[] shiftLeftEffective(double[] arr, int shift) {
        shift %= arr.length;
        double[] tempArr = new double[shift];

        // store elements (to be moved to the end) to the separate array
        for(int i = 0; i < shift; i++) {
            tempArr[i]=arr[i];
        }

        // shift elements (to be shifted) in the original array
        for(int i = 0; i < arr.length - shift; i++) {
            arr[i]=arr[i + shift];
        }

        // replace elements in the end of the original array with the elements from the separate array
        for(int i = arr.length - shift; i < arr.length; i++) {
            arr[i] = tempArr[i - arr.length + shift];
        }

        return arr;
    }

    @Test
    public void testCases() {
        double[] arr = {1, 2, 3, 4, 5};
        int shift = 2;
        double[] expected = new double[]{3, 4, 5, 1, 2};
        assertArrayEquals(expected, shiftLeft(arr, shift), 0);

        arr = new double[]{1, 2, 3, 4, 5};
        shift = 6;
        expected = new double[]{2, 3, 4, 5, 1};
        assertArrayEquals(expected, shiftLeft(arr, shift), 0);

        arr = new double[]{1, 2, 3, 4, 5};
        shift = 0;
        expected = new double[]{1, 2, 3, 4, 5};
        assertArrayEquals(expected, shiftLeft(arr, shift), 0);

        arr = new double[]{1, 2, 3, 4, 5};
        shift = 555;
        expected = new double[]{1, 2, 3, 4, 5};
        assertArrayEquals(expected, shiftLeft(arr, shift), 0);

        arr = new double[]{1, 2, 3, 4, 5};
        shift = 2;
        expected = new double[]{3, 4, 5, 1, 2};
        assertArrayEquals(expected, shiftLeftEffective(arr, shift), 0);

        arr = new double[]{1, 2, 3, 4, 5};
        shift = 6;
        expected = new double[]{2, 3, 4, 5, 1};
        assertArrayEquals(expected, shiftLeftEffective(arr, shift), 0);

        arr = new double[]{1, 2, 3, 4, 5};
        shift = 0;
        expected = new double[]{1, 2, 3, 4, 5};
        assertArrayEquals(expected, shiftLeftEffective(arr, shift), 0);

        arr = new double[]{1, 2, 3, 4, 5};
        shift = 555;
        expected = new double[]{1, 2, 3, 4, 5};
        assertArrayEquals(expected, shiftLeftEffective(arr, shift), 0);
    }
}
