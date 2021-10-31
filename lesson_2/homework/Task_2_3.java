package homework;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
    Дан массив целых чисел размера 2n + 1. Известно, что для каждого числа есть пара, но только для одного пары нет.
    Найти такое число.
 */
public class Task_2_3 {

    // O(n + k)
    // restrictions: only int values
    private int findWithoutPair(int[] arr) {
        int result = arr[0];
        int max = arr[0];

        // find max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // initialize an array to count pairs
        int[] pairCounter = new int[max + 1];
        for (int j : arr) {
            // handle situations with repetitions of numbers in an array;
            // otherwise, pairCounter[j]++ can be used
            if (pairCounter[j] == 2) pairCounter[j]--;
            else pairCounter[j]++;
        }

        // find i's element with value < 2 (pair was not found)
        for (int i = 0; i < pairCounter.length; i++) {
            if (pairCounter[i] == 1) result = i;
        }

        return result;
    }

    // O(n)
    private int findWithoutPairEffective(int[] arr) {
        Map<Integer, Integer> pairMap = new HashMap<>();

        int value;
        for (int i = 0; i < arr.length; i++) {
            value = pairMap.getOrDefault(arr[i], 0);
            value = value == 2 ? 0 : value;
            pairMap.put(arr[i], ++value);
        }

        return pairMap.keySet().stream()
                .filter(key -> pairMap.get(key) == 1)
                .findFirst()
                .orElse(0);
    }

    @Test
    public void testCases() {
        int[] arr = {1, 1, 2, 2, 3};
        assertEquals(3, findWithoutPair(arr));

        // equals elements
        arr = new int[]{3, 3, 3, 3, 3, 3, 3};
        assertEquals(3, findWithoutPair(arr));

        //
        arr = new int[]{3, 3, 3, 3, 5, 5, 8, 8, 10};
        assertEquals(10, findWithoutPair(arr));

        //
        arr = new int[]{3, 3, 3, 3, 5, 5, 8, 8, 10000};
        assertEquals(10000, findWithoutPair(arr));

        arr = new int[]{1, 1, 2, 2, 3};
        assertEquals(3, findWithoutPairEffective(arr));

        // equals elements
        arr = new int[]{3, 3, 3, 3, 3, 3, 3};
        assertEquals(3, findWithoutPairEffective(arr));

        //
        arr = new int[]{3, 3, 3, 3, 5, 5, 8, 8, 10};
        assertEquals(10, findWithoutPairEffective(arr));

        //
        arr = new int[]{3, 3, 3, 3, 5, 5, 8, 8, 10000};
        assertEquals(10000, findWithoutPairEffective(arr));

        //
        arr = new int[]{1, 2, 1, 4, 5, 4, 5};
        assertEquals(2, findWithoutPair(arr));

        //
        arr = new int[]{1, 2, 1, 4, 5, 4, 5};
        assertEquals(2, findWithoutPairEffective(arr));
    }
}
