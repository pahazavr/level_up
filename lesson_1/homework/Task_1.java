package homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Given three numbers.
    Find among them the median mean value in sorted sequence.
        - (2, 7, 3) -> 3
 */
public class Task_1 {

    // O(1)
    public static double medianFindEffective(double n1, double n2, double n3) {
        if ((n1 > n2 && n1 < n3) || (n1 < n2 && n1 > n3) || (n1 == n2) || (n1 == n3))
            return n1;
        else if ((n2 > n1 && n2 < n3) || (n2 < n1 && n2 > n3) || (n2 == n3))
            return n2;
        else return n3;
    }

    @Test
    public void testCases() {
        double n1 = 2, n2 = 7, n3 = 3;
        assertEquals(3, medianFindEffective(n1, n2, n3), 0);

        n1 = 2;
        n2 = 3;
        n3 = 7;
        assertEquals(3, medianFindEffective(n1, n2, n3), 0);

        n1 = 7;
        n2 = 2;
        n3 = 3;
        assertEquals(3, medianFindEffective(n1, n2, n3), 0);

        n1 = 2;
        n2 = 2;
        n3 = 2;
        assertEquals(2, medianFindEffective(n1, n2, n3), 0);

        n1 = 3;
        n2 = 2;
        n3 = 3;
        assertEquals(3, medianFindEffective(n1, n2, n3), 0);

        n1 = 2;
        n2 = 3;
        n3 = 3;
        assertEquals(3, medianFindEffective(n1, n2, n3), 0);

        n1 = 2;
        n2 = 2;
        n3 = 3;
        assertEquals(2, medianFindEffective(n1, n2, n3), 0);
    }
}
