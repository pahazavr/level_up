package homework;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*
    Given an array of numbers. It is required to find a number that uniformly
    far from the minimum and maximum closest to the average.
        - (1, 5, 6, 8, 10) -> 5
 */
public class Task_3 {

    // O(nlog(n))
    private static double mediumFind(double[] arr) {
        // O(nlog(n))
        Arrays.sort(arr);

        double medium = (arr[arr.length - 1] - arr[0]) / 2 ;
        double result = arr[0];
        double diff = arr[arr.length - 1];

        for (double num : arr) {
            double temp = Math.abs(num - medium);
            if (diff > temp) {
                diff = temp;
                result = num;
            }
        }

        return result;
    }

    // O(n)
    private static double mediumFindEffective(double[] arr) {

        double min = arr[0];
        double max = arr[0];

        // find max and min
        for(double num: arr) {
            if(num < min) min = num;
            else if(num > max) max = num;
        }

        double medium = (max - min) / 2;
        double result = min;
        double diff = max;

        for (double num : arr) {
            double temp = Math.abs(num - medium);
            if (temp < diff) {
                diff = temp;
                result = num;
            }
        }

        return result;
    }

    @Test
    public void testCases() {
        double[] arr = {10, 5, 6, 8, 1};
        assertEquals(5, mediumFind(arr), 0);

        arr = new double[]{10, 10, 10, 10, 10};
        assertEquals(10, mediumFind(arr), 0);

        arr = new double[]{0, 0, 0, 0, 0};
        assertEquals(0, mediumFind(arr), 0);

        arr = new double[]{10, 5, 6, 8, 1};
        assertEquals(5, mediumFindEffective(arr), 0);

        arr = new double[]{10, 10, 10, 10, 10};
        assertEquals(10, mediumFindEffective(arr), 0);

        arr = new double[]{0, 0, 0, 0, 0};
        assertEquals(0, mediumFindEffective(arr), 0);
    }
}
