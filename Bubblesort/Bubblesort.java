package bubblesort;

import java.sql.SQLOutput;
import java.util.Random;



public class Bubblesort {
    public static void main(String[] args) {

        Integer[] nums = new Integer[15];
        for(int i = 0; i < nums.length; i++){
            nums[i] = getRandomNumberUsingNextInt(1, 2000);
        }
        int numcykl = 0;
        print(nums);
        while(!result(nums)){
            sort(nums);
            numcykl++;
        }

        print(nums);
        System.out.println("Number of cycles: "+numcykl);
    }

    private static boolean result(Integer[] nums) {
        boolean sort = false;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                return false;
            }else{
                sort = true;
            }
        }
        return true;
    }

    private static void sort(Integer[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                int a = nums[i];
                int b = nums[i+1];
                nums[i] = b;
                nums[i+1] = a;
            }
        }
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
