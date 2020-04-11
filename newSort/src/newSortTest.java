import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class newSortTest {

    /*
     * Test case 1:
     * testNewSort[1, 2, 3]
     */

    @Test
    public void testNewSort1() { //NUMBER 1//
        newSort sol = new newSort();
        int[] A = {3,2,1};
        int[] result = {1,2,3};
        sol.newSort(A, 3);
        assertArrayEquals(result, A);
    }
}