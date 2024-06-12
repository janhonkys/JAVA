package bubblesort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {

    @Test
    void testSort(){
        // Create an array with unsorted elements
        Integer[] unsortedArray = {5, 2, 8, 3, 1};

        // Do sorting
        int cyclesNumber = BubbleSort.sort(unsortedArray);

        // Create an array with expected sorted elements
        Integer[] expectedArray = {1, 2, 3, 5, 8};

        // Verify that the array is sorted
        assertArrayEquals(expectedArray, unsortedArray, "Array should be sorted");

        // Verify the number of sorting cycles
        assertEquals(5, cyclesNumber, "Number of cycles should be 5");
    }
}
