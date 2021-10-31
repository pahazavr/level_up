package homework;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

public class RadixSort {

    private static int offset;

    private int[] sort(int[] arr) {
        int max = arr[0];

        // find max
        // O(n)
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int exp = 1;
        while (max / 10 != 0) {
            exp *= 10;
            max /= 10;
        }

        offset = 0;
        return MSD(arr, arr, exp);
    }

    private static int[] MSD(int[] arr, int[] subarray, int exp) {
        // map for storing the elements of an array in accordance with its number system value
        final Map<Integer, int[]> counterMap = new HashMap<>();
        counterMap.put(0, new int[subarray.length]);
        counterMap.put(1, new int[subarray.length]);
        counterMap.put(2, new int[subarray.length]);
        counterMap.put(3, new int[subarray.length]);
        counterMap.put(4, new int[subarray.length]);
        counterMap.put(5, new int[subarray.length]);
        counterMap.put(6, new int[subarray.length]);
        counterMap.put(7, new int[subarray.length]);
        counterMap.put(8, new int[subarray.length]);
        counterMap.put(9, new int[subarray.length]);

        int[] currArr;
        int i = -1;
        // fill the counterMap
        while (i < subarray.length - 1 && subarray[++i] != 0) {
            int radix = getRadix(subarray[i], exp);
            if (radix > 0) {
                currArr = counterMap.get(radix);
                for (int j = 0; j < currArr.length; j++) {
                    if (currArr[j] == 0) {
                        currArr[j] = subarray[i];
                        break;
                    }
                }
                counterMap.put(radix, currArr);
            }
        }

        // fill the original array if value of a map contains only 1 value;
        // otherwise, call MSD() again
        for (i = 0; i < 10; i++) {
            currArr = counterMap.get(i);
            if (exp / 10 > 0 && currArr[0] != 0 && currArr[1] != 0) {
                MSD(arr, currArr, exp / 10);
            } else if (currArr[0] != 0) {
                arr[offset++] = currArr[0];
            }
        }

        return arr;
    }

    private static int getRadix(int element, int exp) {
        return (element / exp) % 10 != 0 ? element / exp % 10 : 0;
    }

    @Test
    public void testCases() {
        int[] arr = {932, 311, 457, 163, 330, 118, 953, 949, 381, 166};
        int[] expected = {118, 163, 166, 311, 330, 381, 457, 932, 949, 953};
        assertArrayEquals(expected, sort(arr));

        arr = new int[]{329, 457, 657, 839, 436, 720, 355};
        expected = new int[]{329, 355, 436, 457, 657, 720, 839};
        assertArrayEquals(expected, sort(arr));

        arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        expected = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expected, sort(arr));

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, sort(arr));

        arr = new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        expected = new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, sort(arr));
    }
}
