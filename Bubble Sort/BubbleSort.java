package bubblesort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    // Random object for generating random numbers
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Create an array of integers
        Integer[] nums = new Integer[15];

        // Fill the array with random numbers between 1 and 2000
        for(int i = 0; i < nums.length; i++){
            nums[i] = getRandomNumberUsingNextInt(1, 2000);
        }

        // Print the original array
        System.out.println("Original:");
        System.out.println(Arrays.toString(nums));

        // Perform Bubble Sort on the array
        int cycles = sort(nums);

        // Print the sorted array
        System.out.println("After bubble sort:");
        System.out.println(Arrays.toString(nums));

        // Print the number of sorting cycles
        System.out.println("Number of cycles: " + cycles);
    }

    // Method to perform Bubble Sort on an array of integers
    protected static int sort(Integer[] nums) {
        // Flag to indicate whether the array is sorted
        boolean isSorted = false;
        // Counter to keep track of the number of sorting cycles
        int numIterations = 0;

        // Continue sorting until the array is sorted or contains only one element
        while(nums.length > 1 && !isSorted){
            isSorted = true;
            // Iterate through the array and perform the sorting
            for(int i = 0; i < nums.length - 1; i++){
                // If the current element is greater than the next element, swap them
                if(nums[i] > nums[i+1]){
                    isSorted = false;
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            // Increment the number of sorting cycles
            numIterations++;
        }

        // Return the total number of sorting cycles performed
        return numIterations;
    }




    // Method to generate a random integer between a specified range
    public static int getRandomNumberUsingNextInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
