package bubblesort;

import java.util.Random;

public class Bubblesort {
    public static void main(String[] args) {
        Integer[] nums = new Integer[15];
        for(int i = 0; i < nums.length; i++){
            nums[i] = getRandomNumberUsingNextInt(1, 2000);
        }
        System.out.println("Original:");
        print(nums);
        int cyklus = sort(nums);
        System.out.println("After bubblesort:");
        print(nums);
        System.out.println("Number of cycles: "+cyklus);
    }

    private static int sort(Integer[] nums) {
        boolean sort = false;
        int numcykl = 0;
        while(nums.length != 1 && !sort){
            sort = true;
            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] > nums[i+1]){
                    sort = false;
                    int a = nums[i];
                    int b = nums[i+1];
                    nums[i] = b;
                    nums[i+1] = a;
                }
            }
            numcykl++;
        }
        return numcykl;
    }

    private static void print(Integer[] nums) {
        for(Integer a : nums){
            System.out.print(a+" ");
        }
        System.out.println("");
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
