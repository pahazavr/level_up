package homework;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
    Даны два упорядоченных массива. Требуется выполнить слияние этих массивов.
    Результат – упорядоченный массив.
 */
public class Task_2_1 {

    // O(n + m) -> O(arr1.length + arr2.length)
    private double[] mergeSort(double[] arr1, double[] arr2) {
        double[] result = new double[arr1.length + arr2.length];

        boolean desc = false;
        boolean asc = false;

        if ((arr1[0] < arr1[arr1.length - 1] || arr1[0] == arr1[arr1.length - 1]) &&
                (arr2[0] < arr2[arr2.length - 1] || arr2[0] == arr2[arr2.length - 1])) asc = true;
        else if (arr1[0] > arr1[arr1.length - 1] && arr2[0] > arr2[arr2.length - 1]) desc = true;

        if (asc || desc) {
            int indexArr1 = 0;
            int indexArr2 = 0;
            for (int i = 0; i < result.length; i++) {
                if (indexArr1 >= arr1.length || indexArr2 >= arr2.length) {
                    if (indexArr1 >= arr1.length) {
                        result[i] = arr2[indexArr2++];
                    } else {
                        result[i] = arr1[indexArr1++];
                    }
                } else {
                    if (asc) {
                        if (arr1[indexArr1] < arr2[indexArr2]) {
                            result[i] = arr1[indexArr1++];
                        } else {
                            result[i] = arr2[indexArr2++];
                        }
                    } else if (desc) {
                        if (arr1[indexArr1] > arr2[indexArr2]) {
                            result[i] = arr1[indexArr1++];
                        } else {
                            result[i] = arr2[indexArr2++];
                        }
                    }
                }
            }
        } else {
            boolean isArr1Asc = arr1[0] < arr1[1];
            int indexArr1 = isArr1Asc ? 0 : arr1.length - 1;
            int indexArr2 = !isArr1Asc ? 0 : arr2.length - 1;
            for (int i = 0; i < result.length; i++) {
                if (isArr1Asc) {
                    if (indexArr1 >= arr1.length || indexArr2 < 0) {
                        if (indexArr1 >= arr1.length) {
                            result[i] = arr2[indexArr2--];
                        } else {
                            result[i] = arr1[indexArr1++];
                        }
                    } else if (arr1[indexArr1] < arr2[indexArr2]) {
                        result[i] = arr1[indexArr1++];
                    } else {
                        result[i] = arr2[indexArr2--];
                    }
                } else {
                    if (indexArr2 >= arr2.length || indexArr1 < 0) {
                        if (indexArr2 >= arr2.length) {
                            result[i] = arr2[indexArr1--];
                        } else {
                            result[i] = arr1[indexArr2++];
                        }
                    } else if (arr1[indexArr1] < arr2[indexArr2]) {
                        result[i] = arr1[indexArr1--];
                    } else {
                        result[i] = arr2[indexArr2++];
                    }
                }
            }
        }

        return result;
    }

    @Test
    public void testCases() {
        // по порядку, ASC
        double[] arr1 = {1, 2, 3, 4, 5};
        double[] arr2 = {6, 7, 8, 9, 10};
        double[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // не по порядку, ASC
        arr1 = new double[]{1, 2, 6, 7, 8};
        arr2 = new double[]{3, 4, 5, 9, 10};
        expected = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // по порядку, ASC, разной длины
        arr1 = new double[]{1, 2, 3, 4, 5};
        arr2 = new double[]{6, 7, 8, 9, 10, 11, 12, 13};
        expected = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // по порядку, DESC
        arr1 = new double[]{5, 4, 3, 2, 1};
        arr2 = new double[]{10, 9, 8, 7, 6};
        expected = new double[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // не по порядку, DESC
        arr1 = new double[]{8, 7, 6, 2, 1};
        arr2 = new double[]{10, 9, 5, 4, 3};
        expected = new double[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // по порядку, DESC, разной длины
        arr1 = new double[]{5, 4, 3, 2, 1};
        arr2 = new double[]{13, 12, 11, 10, 9, 8, 7, 6};
        expected = new double[]{13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // по порядку, разная сортировка
        arr1 = new double[]{1, 2, 3, 4, 5};
        arr2 = new double[]{10, 9, 8, 7, 6};
        expected = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // не по порядку, разная сортировка
        arr1 = new double[]{1, 2, 6, 7, 8};
        arr2 = new double[]{10, 9, 5, 4, 3};
        expected = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // не по порядку, разная сортировка
        arr1 = new double[]{1, 2, 6, 7, 8};
        arr2 = new double[]{13, 12, 11, 10, 9, 5, 4, 3};
        expected = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // по порядку, ASC, разной длины, одинаковые элементы
        arr1 = new double[]{1, 2, 3, 4, 5};
        arr2 = new double[]{3, 3, 3, 3, 6, 7, 8, 9, 10, 11, 12, 13};
        expected = new double[]{1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // по порядку, ASC, разной длины, одинаковые элементы
        arr1 = new double[]{1, 2, 3, 4, 5};
        arr2 = new double[]{3, 3, 3, 3, 6, 7, 8, 9, 10, 11, 12, 13};
        expected = new double[]{1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // не по порядку, ASC, разной длины, одинаковые элементы
        arr1 = new double[]{1, 2, 3, 4, 5, 5, 5, 7, 7, 12, 13, 14};
        arr2 = new double[]{3, 3, 3, 3, 8, 9, 10, 11, 12, 13};
        expected = new double[]{1, 2, 3, 3, 3, 3, 3, 4, 5, 5, 5, 7, 7, 8, 9, 10, 11, 12, 12, 13, 13, 14};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);

        // не по порядку, разная сортировка, разной длины, одинаковые элементы
        arr1 = new double[]{1, 2, 3, 4, 5, 5, 5, 7, 7, 12, 13, 14};
        arr2 = new double[]{13, 12, 11, 10, 9, 8, 3, 3, 3, 3};
        expected = new double[]{1, 2, 3, 3, 3, 3, 3, 4, 5, 5, 5, 7, 7, 8, 9, 10, 11, 12, 12, 13, 13, 14};
        assertArrayEquals(expected, mergeSort(arr1, arr2), 0);
    }
}
